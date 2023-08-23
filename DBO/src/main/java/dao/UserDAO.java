package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import dto.MemberDTO;

@Repository
@Mapper
public interface UserDAO {
	void signUp(MemberDTO member);
	public MemberDTO signIn(MemberDTO dto);
	public int isMemberIdExist(String inputId);
    public int isMemberEmailExist(String inputEmail);
}
