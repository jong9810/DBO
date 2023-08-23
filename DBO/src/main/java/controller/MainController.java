package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberDTO;


@Controller
public class MainController {
	
	@RequestMapping("/main")
	public ModelAndView main(@SessionAttribute(name = "userlogin", required = false)MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		if (dto != null) {
			mv.addObject("loginNick", dto.getMember_nick());
		}
		mv.setViewName("DBOMain");
		return mv;
	}
}
