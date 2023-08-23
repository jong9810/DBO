package service;

import java.util.Map;

import dto.MemberDTO;

public interface MypageService {
	// 회원의 현재 정보 가져오기
	MemberDTO selectMemberInfo(String member_id);
		
	// 회원 정보 수정
	int updateMemberNick(MemberDTO dto); 
	int updateMemberPw(MemberDTO dto);
	String selectMemberCurPw(String member_id);
	int deleteMember(Map<String, String> map);
	
	// 회원 최근 전적
	Map<String, Object> getLatestRecords(String member_id, int detailIdx);
	
}
