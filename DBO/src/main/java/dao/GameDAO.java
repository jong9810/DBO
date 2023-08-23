package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import dto.ExpDTO;
import dto.InningsDTO;
import dto.MemberDTO;
import dto.SingleDTO;

@Repository
@Mapper
public interface GameDAO {
	int insertSingle(SingleDTO dto);
	int updateSingle(SingleDTO dto);
	int updateMember(MemberDTO dto);
	int insertInnings(InningsDTO dto);
	int insertExp(ExpDTO dto);
	MemberDTO selectMember(String member_id);
}
