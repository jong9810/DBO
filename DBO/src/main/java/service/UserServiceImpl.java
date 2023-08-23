package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import dto.MemberDTO;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;
	
	public void signUp(MemberDTO member) {
		dao.signUp(member);
	}
	
	public MemberDTO signIn(MemberDTO dto) {
		return dao.signIn(dto);
	}
	
    public int isMemberIdExist(String inputId) {
    	return dao.isMemberIdExist(inputId);
    }
    
    public int isMemberEmailExist(String inputEmail) {
    	return dao.isMemberEmailExist(inputEmail);
    }	

	
}
