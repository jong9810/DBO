package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import service.HashService;
import service.MypageService;

@Controller
public class MypageController {
	
	@Autowired
	@Qualifier("mypageServiceImpl")
	MypageService service;
	
	@Autowired
	private HashService hashService;
	
	@Value("${hash.bcrypt.number}")
	private int hashNum;
	
	// 닉네임 변경 폼 열기
	@GetMapping("/changeNick")
	public ModelAndView changeNick(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("userlogin") == null) {
			mv.setViewName("redirect:/main");
		}
		mv.setViewName("changeNick");
		return mv;
	}
	
	// 회원 닉네임 변경
	@PostMapping("/updateNick")
	@ResponseBody
	public Map<String, Integer> updateNick(HttpSession session, String newNick) {
		Map<String, Integer> response = new HashMap<>();
		int updateResult = -9999;
		if (session.getAttribute("userlogin") == null) {
			updateResult = -1;
		} else {
			MemberDTO dto = (MemberDTO) session.getAttribute("userlogin");
			if (dto.getMember_nick().equals(newNick)) { // 현재 닉네임과 같다면 
				updateResult = -2;
			}
			else {
				dto.setMember_nick(newNick);
				updateResult = service.updateMemberNick(dto);
			}
		}
		response.put("updateResult", updateResult);
		return response;
	}
	
	// 비밀번호 변경 폼 열기
	@GetMapping("/changePw")
	public ModelAndView changePw(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("userlogin") == null) {
			mv.setViewName("redirect:/main");
		}
		mv.setViewName("changePw");
		return mv;
	}
	
	// 회원 비밀번호 변경
	@PostMapping("/updatePw")
	@ResponseBody
	public Map<String, Integer> updatePw(HttpSession session, String curPw, String newPw1, String newPw2) {
		Map<String, Integer> response = new HashMap<>();
		int updateResult = -9999;
		if (session.getAttribute("userlogin") == null) {
			updateResult = -1;
		} else {
			MemberDTO dto = (MemberDTO) session.getAttribute("userlogin"); // 로그인 회원 DTO
			String member_id = dto.getMember_id();
			String member_curPw = service.selectMemberCurPw(member_id); // 회원의 현재 비밀번호
			
			if (!curPw.equals(member_curPw)) { // 현재 비밀번호를 틀렸다면
				updateResult = -2;
			} else if (!newPw1.equals(newPw2)) { // 비밀번호 확인이 맞지 않다면
				updateResult = -3;
			} else if (curPw.equals(newPw1) && curPw.equals(newPw2)) { // 현재 비밀번호와 새 비밀번호가 같다면
				updateResult = -4;
			} else {
				dto.setMember_pw(newPw1);
				updateResult = service.updateMemberPw(dto);
			}
		}
		response.put("updateResult", updateResult);
		return response;
	}
	
	// 회원 탈퇴
	@PostMapping("/deleteMember")
	@ResponseBody
	public Map<String, Integer> deleteMember(HttpSession session) {
		Map<String, Integer> response = new HashMap<>();
		int deleteResult = -9999;
		if (session.getAttribute("userlogin") == null) {
			deleteResult = -1;
		} else {
			String member_id = ((MemberDTO) session.getAttribute("userlogin")).getMember_id();
			String member_pw = service.selectMemberCurPw(member_id);
			Map<String, String> map = new HashMap<>();
			
			// 탈퇴하는 회원 아이디, 비번에 해시함수 적용
			String hash_member_id = hashService.encodeBcrypt(member_id, hashNum);
			String hash_member_pw = hashService.encodeBcrypt(member_pw, hashNum);
			
			map.put("member_id", member_id);
			map.put("hash_member_id", hash_member_id);
			map.put("hash_member_pw", hash_member_pw);
			map.put("member_team", null);
			deleteResult = service.deleteMember(map);
		}
		session.removeAttribute("userlogin");
		response.put("deleteResult", deleteResult);
		return response;
	}
	
	// 회원의 마이페이지로 이동
	@GetMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		// 만약 로그인한 회원이 아닌 경우 메인으로 redirect
		if (session.getAttribute("userlogin") == null) {
			mv.setViewName("redirect:/main");
			return mv;
		}
		mv.setViewName("mypage");
		
		String member_id = ((MemberDTO) session.getAttribute("userlogin")).getMember_id();
		MemberDTO dto = service.selectMemberInfo(member_id);
		Map<String, Object> serviceResult = service.getLatestRecords(member_id, -1);
		
		// 회원 경험치에 따라 레벨과 경험치 퍼센트 구해서 뷰에 보냄
		int[] lv_cut = {0, 3000, 10000, 22000, 40000, 65000, 98000, 140000, 192000, 255000};
		int member_allexp = dto.getMember_allexp();
		int member_lv = 0;
		double exp_percent = 0;
		for (int i = 0; i < lv_cut.length - 1; i++) {
			if (member_allexp >= lv_cut[i] && member_allexp < lv_cut[i + 1]) {
				member_lv = i + 1;
				exp_percent = ((double) member_allexp - lv_cut[i]) / (lv_cut[i + 1] - lv_cut[i]) * 100;
				break;
			}
		}
		
		double win_rate = (double) dto.getMember_win() / dto.getMember_total() * 100;
		
		List<Map<String, String>> singleRecords = (List<Map<String, String>>) serviceResult.get("singleRecords");
		
		// 뷰에 뿌려줄 데이터
		mv.addObject("memberDto", dto); // 회원 DTO
		mv.addObject("member_lv", member_lv); // 회원 레벨
		mv.addObject("exp_percent", Math.round(exp_percent * 10) / 10.0); // 회원 경험치 퍼센트
		mv.addObject("win_rate", Math.round(win_rate * 10) / 10.0); // 회원 DTO
		mv.addObject("singleRecords", singleRecords); // 회원 최근 전적
		
		return mv;
	}
	
	// 최근 전적에서 상세전적 보기 버튼 누르면 해당 전적의 상세 내용을 보여줌
	@PostMapping("/showRecordDetail")
	@ResponseBody
	public Map<String, Object> showRecordDetail(HttpSession session, int detailIdx) {
		Map<String, Object> ajaxResult = new HashMap<>();
		if (session.getAttribute("userlogin") == null) {
			ajaxResult.put("ajaxResult", -1);
			return ajaxResult;
		}
		String member_id = ((MemberDTO) session.getAttribute("userlogin")).getMember_id();
		Map<String, Object> serviceResult = service.getLatestRecords(member_id, detailIdx);
		ajaxResult.put("ajaxResult", 1);
		ajaxResult.put("singleRecords", serviceResult.get("singleRecords"));
		ajaxResult.put("singleDetails", serviceResult.get("singleDetails"));
		return ajaxResult;
	}
	
	
}