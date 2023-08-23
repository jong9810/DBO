package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.MypageDAO;
import dto.ExpDTO;
import dto.InningsDTO;
import dto.MemberDTO;
import dto.SingleDTO;

@Service	
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	@Qualifier("mypageDAO")
	MypageDAO dao;
	
	// 회원의 현재 정보 가져오기
	@Override
	public MemberDTO selectMemberInfo(String member_id) {
		return dao.selectMemberInfo(member_id);
	}

	// 닉네임 변경
	@Override
	public int updateMemberNick(MemberDTO dto) {
		return dao.updateMemberNick(dto);
	}

	// 비밀번호 변경
	@Override
	public int updateMemberPw(MemberDTO dto) {
		return dao.updateMemberPw(dto);
	}
	
	// 회원의 현재 비밀번호
	@Override
	public String selectMemberCurPw(String member_id) {
		return dao.selectMemberCurPw(member_id);
	}
	
	// 회원탈퇴
	@Override
	public int deleteMember(Map<String, String> map) {
		return dao.deleteMember(map);
	}

	// 회원 최근 전적(싱글 게임)
	@Override
	public Map<String, Object> getLatestRecords(String member_id, int detailIdx) {
		Map<String, Object> serviceResult = new HashMap<>(); // 결과 반환 map
		
		// 회원의 최근 5게임 single_id, exp_date를 exp 테이블에서 가져옴
		List<ExpDTO> expDtos = dao.selectLatestExps(member_id);
		
		// 회원이 게임을 플레이한 적이 없으면 return
		if (expDtos.isEmpty()) return serviceResult; 
		
		// 가져온 결과를 각각 single_ids, exp_dates 리스트에 저장
		List<Integer> single_ids = new ArrayList<>();
		List<Timestamp> exp_dates = new ArrayList<>();
		for (ExpDTO dto : expDtos) {
			single_ids.add(dto.getSingle_id());
			exp_dates.add(dto.getExp_date());
		}
		
		// 회원의 최근 전적 5개 가져옴
		List<SingleDTO> singleDtos = getLatestSingleRecords(single_ids, member_id);; 
		List<InningsDTO> inningsDtos = null; // 각 싱글 게임 회차별 결과
		if (detailIdx >= 0) { // 상세보기일 경우
			// 선택한 detailIdx에 해당하는 전적 상세 내용(innings_count, innings_strike, innings_ball) 가져옴
			inningsDtos = dao.selectLatestInnings(single_ids.get(detailIdx));
		}
		
		// 결과 반환
		List<Map<String, String>> singleRecords = new ArrayList<>();
		for (int i = 0; i < singleDtos.size(); i++) {
			Map<String, String> temp = new HashMap<>();
			if(singleDtos.get(i).isSingle_result()) temp.put("single_result", "성공");
			else temp.put("single_result", "실패");
			temp.put("single_all", String.valueOf(singleDtos.get(i).getSingle_all()));
			temp.put("single_answer", singleDtos.get(i).getSingle_answer());
			temp.put("exp_date", String.valueOf(exp_dates.get(i)));
			singleRecords.add(temp);
		}
		serviceResult.put("singleRecords", singleRecords);
		serviceResult.put("singleDetails", inningsDtos);
		
		return serviceResult;
	}
	
	// 회원의 최근 5게임 single_all, single_result, single_answer 를 single 테이블에서 가져옴
	public List<SingleDTO> getLatestSingleRecords(List<Integer> single_ids, String member_id) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("single_ids", single_ids);
		map.put("member_id", member_id);
		return dao.selectLatestSingleRecords(map);
	}
	
}
