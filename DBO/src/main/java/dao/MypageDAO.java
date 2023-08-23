package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import dto.ExpDTO;
import dto.InningsDTO;
import dto.MemberDTO;
import dto.SingleDTO;

@Repository
@Mapper
public interface MypageDAO {
	// 회원의 현재 정보 가져오기
	MemberDTO selectMemberInfo(String member_id);
	
	// 회원 정보 수정
	int updateMemberNick(MemberDTO dto); // 닉네임 변경
	int updateMemberPw(MemberDTO dto); // 비밀번호 변경
	String selectMemberCurPw(String member_id); // 회원의 현재 비밀번호
	int deleteMember(Map<String, String> map); // 회원탈퇴
	
	// 회원 최근 전적
	List<ExpDTO> selectLatestExps(String member_id); // 회원의 최근 게임 플레이 날짜, 게임 id
	List<SingleDTO> selectLatestSingleRecords(HashMap<String, Object> map); // 회원의 최근 싱글 게임 결과, 도전 횟수
	ArrayList<InningsDTO> selectLatestInnings(int single_id); // 회원의 최근 게임 중 하나의 상세 결과(회차, 볼수, 스트라이크수)
	
}
