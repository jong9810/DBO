package service;

import dto.ExpDTO;
import dto.InningsDTO;
import dto.MemberDTO;
import dto.SingleDTO;

public interface GameService {
	int insertSingle(SingleDTO dto);
	int updateSingle(SingleDTO dto);
	int updateMember(MemberDTO dto);
	int insertInnings(InningsDTO dto);
	int insertExp(ExpDTO dto);
	MemberDTO selectMember(String member_id);
}
