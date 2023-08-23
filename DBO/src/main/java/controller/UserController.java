package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;


@Controller
public class UserController {
	 @Autowired
	 UserService service;
	
	//회원가입
	@GetMapping("/join")
	public String signUp() {
		return "signUp";
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String signUp(@ModelAttribute("member") MemberDTO member) {
		service.signUp(member);
		
		return "redirect:/login";
	}
	
	//로그인
	@GetMapping("/login")
	public String signIn(@SessionAttribute(name = "userlogin", required = false)MemberDTO dto, HttpServletResponse response, HttpServletRequest request) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
			
		if (dto == null) {
	    	return "signIn";
		} else {
			return "redirect:" + request.getHeader("Referer");
		}	
	}
	
	@PostMapping("/login")
	public String userSignIn(@ModelAttribute MemberDTO dto, HttpServletResponse response,
	HttpServletRequest request, Model m) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("userlogin") == null) {
			MemberDTO mdto = service.signIn(dto);
			if (mdto != null) {
				 MemberDTO medto = new MemberDTO();
				 medto.setMember_id(mdto.getMember_id());
				 medto.setMember_nick(mdto.getMember_nick());
				 medto.setMember_email(mdto.getMember_email());
				 medto.setMember_team(mdto.getMember_team());
				 medto.setMember_allexp(mdto.getMember_allexp());
				 medto.setMember_total(mdto.getMember_total());
				 medto.setMember_win(mdto.getMember_win());
				
				session = request.getSession();
				session.setAttribute("userlogin", medto);
				return "redirect:/main";
			} else {
				m.addAttribute("loginfail", "아이디 또는 비밀번호가 맞지 않습니다.");
				return "signIn";
			}
		} else {
			return "redirect:/main";
		}
	}
	
		// 로그아웃
		@RequestMapping("/logout")
		public String logout(HttpServletResponse response, HttpServletRequest request) {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setDateHeader("Expires", 0); // Proxies.

			HttpSession session = request.getSession(false);

			if (session != null) {
				session.invalidate();
			}

			return "signIn";
		}
		
		//id, email 중복 여부
	    @RequestMapping(value="/ismemberexist", produces = {"application/json;charset=utf-8"})
	    public @ResponseBody String isMemberexist(@RequestParam("inputId") String inputId, @RequestParam("inputEmail") String inputEmail) {
	    	int idresult = service.isMemberIdExist(inputId);
	    	int emailresult = service.isMemberEmailExist(inputEmail);
	    	String result = "";
	    	
	    	if( idresult == 0 && emailresult == 0) {
	    		result = "ok";
	    	}
	    	else if(idresult == 1 && emailresult == 0) {
	    		result = "one_id";
	    	}
	    	else if(idresult == 0 && emailresult == 1) {
	    		result = "one_email";
	    	}
	    	else {
	    		result = "both";
	    	}
	    	return "{\"result\" : \"" + result+ " \" }";
	    }    
	
}