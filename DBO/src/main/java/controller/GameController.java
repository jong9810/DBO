package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.ExpDTO;
import dto.InningsDTO;
import dto.MemberDTO;
import dto.SingleDTO;
import jakarta.servlet.http.HttpSession;
import service.GameServiceImpl;


@Controller
public class GameController {
	@Autowired
	@Qualifier("gameServiceImpl")
	GameServiceImpl service;
	
	//게임페이지
	@GetMapping("/game")
	public ModelAndView game(HttpSession session, @RequestParam(value="mode",required=false ,defaultValue="single")String mode) {
		MemberDTO medto = (MemberDTO)session.getAttribute("userlogin");
		SingleDTO dto = new SingleDTO();
		int single_id = 0;
		ModelAndView mv = new ModelAndView();
		if(mode.equals("rank") && medto != null) {
			dto.setMember_id(medto.getMember_id());
			single_id = service.insertSingle(dto);
			mv.addObject("single_id",single_id);
			mv.addObject("member_id",medto.getMember_id());
		}
		mv.addObject("mode",mode);
		mv.setViewName("game");
		return mv;
	}
	
	@RequestMapping("/ajaxResult")
	@ResponseBody
	public String ajaxResult(HttpSession session,int single_all, int single_result, int single_id, String member_id, String single_answer) {
		MemberDTO mydto = service.selectMember(member_id);
		session.getAttribute("userlogin");
		boolean result = true;
		ExpDTO expdto = new ExpDTO();
		if(single_result == 0) {
			result = false;
			expdto.setMember_id(member_id);
			expdto.setSingle_id(single_id);
			expdto.setExp_amount(0);
			service.insertExp(expdto);
		}
		if(single_result == 1) {
			expdto.setMember_id(member_id);
			expdto.setSingle_id(single_id);
			expdto.setExp_amount(500+((9-single_all)*10));
			service.insertExp(expdto);
		}
		SingleDTO dto = new SingleDTO();
		dto.setSingle_all(single_all);
		dto.setSingle_id(single_id);
		dto.setSingle_result(result);
		dto.setSingle_answer(single_answer);
		service.updateSingle(dto);
		MemberDTO medto = new MemberDTO();
		medto.setMember_id(member_id);
		medto.setMember_total(mydto.getMember_total()+1);
		if(single_result == 1) {
			medto.setMember_allexp(mydto.getMember_allexp()+(500+((9-single_all)*10)));
			medto.setMember_win(mydto.getMember_win()+1);
		}else {
			medto.setMember_allexp(mydto.getMember_allexp());
			medto.setMember_win(mydto.getMember_win());
		}
		service.updateMember(medto);
		return "success";
	}
	
	@RequestMapping("/score")
	@ResponseBody
	public String score(HttpSession session,int  strikes, int  balls, int single_id, int innings_count, String innings_chall) {
		session.getAttribute("userlogin");
		InningsDTO dto = new InningsDTO();
		dto.setInnings_ball(balls);
		dto.setInnings_strike(strikes);
		dto.setInnings_count(innings_count);
		dto.setSingle_id(single_id);
		dto.setInnings_chall(innings_chall);
		service.insertInnings(dto);
		return "success";
	}
	
}