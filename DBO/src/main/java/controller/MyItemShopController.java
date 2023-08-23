package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import dto.MemberDTO;
import dto.MyItemsDTO;
import jakarta.servlet.http.HttpServletResponse;
import service.MyItemsService;

@Controller
public class MyItemShopController {

	@Autowired
	@Qualifier("myItemsServiceImpl")
	MyItemsService service;

	@RequestMapping("/myItemShop")
	public ModelAndView myItemShop(
			@SessionAttribute(name = "userlogin", required = false)MemberDTO dto,
			HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		ModelAndView mv = new ModelAndView();
		
		if (dto != null) {
			mv.addObject("login", "true");
			int exp = service.getexp(dto.getMember_id());
			mv.addObject("exp", exp);
			List<String> solditem = service.getsolditem(dto.getMember_id());
			for (String string : solditem) {
				mv.addObject(string, "sold");
			}
		} else {
			RedirectView rv = new RedirectView();
			rv.setUrl("/login");
			mv.setView(rv);
			return mv;
		}
		
		mv.addObject("nowpage", "nicknameshop");
		mv.setViewName("myItemShop");
		return mv;
	}
	
	@PostMapping("/itembuy")
	public ModelAndView itembuy(
			@SessionAttribute(name = "userlogin", required = false)MemberDTO dto,
			HttpServletResponse response, @RequestBody String item) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		ModelAndView mv = new ModelAndView();
		
		if (dto != null) {
			if (item != null) {
				MyItemsDTO midto = new MyItemsDTO();
				midto.setMember_id(dto.getMember_id());
				String[] parts = item.split("&");
				String[] parts1 = parts[0].split("=");
				String[] parts2 = parts[1].split("=");
				midto.setNicknameitem_name(parts1[1]);
				int price = Integer.parseInt(parts2[1]);
				MemberDTO minusprice = new MemberDTO();
				minusprice.setMember_id(dto.getMember_id());
				minusprice.setMember_allexp(price);
				dto.setMember_allexp(dto.getMember_allexp() - price);
				int result = service.buyitem(midto);
				int result2 = service.minusexp(minusprice);
			}			
			RedirectView rv = new RedirectView();
			rv.setUrl("/myItemShop");
			mv.setView(rv);
			return mv;
		} else {
			RedirectView rv = new RedirectView();
			rv.setUrl("/login");
			mv.setView(rv);
			return mv;
		}
		
	}
	
	@RequestMapping("/mycustoms")
	public ModelAndView mycustoms(@SessionAttribute(name = "userlogin", required = false)MemberDTO dto, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		ModelAndView mv = new ModelAndView();
		
		if (dto != null) {
			mv.addObject("login", "true");
			int exp = service.getexp(dto.getMember_id());
			mv.addObject("exp", exp);
			List<MyItemsDTO> myitems = service.getallmynickitem(dto.getMember_id());
			String nicknameon = "none";
			for (MyItemsDTO myItemsDTO : myitems) {
				if (myItemsDTO.isNicknameitem_use()) {
					nicknameon = myItemsDTO.getNicknameitem_name();
				}
			}
			mv.addObject("nicknameon", nicknameon);
			mv.addObject("myitems", myitems);
		} else {
			RedirectView rv = new RedirectView();
			rv.setUrl("/login");
			mv.setView(rv);
			return mv;
		}
		
		mv.addObject("nowpage", "customs");
		mv.setViewName("mycustoms");
		return mv;
		
	}
	
	@PostMapping("/itemuse")
	public ModelAndView itemuse(
			@SessionAttribute(name = "userlogin", required = false)MemberDTO dto,
			HttpServletResponse response, @RequestBody String item) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		ModelAndView mv = new ModelAndView();
		
		if (dto != null) {
			if (item != null) {
				String[] parts = item.split("&");
				String[] parts1 = parts[0].split("=");
				String[] parts2 = parts[1].split("=");
				if (parts2[1].equals("none")) {
					MyItemsDTO midto = new MyItemsDTO();
					midto.setMember_id(dto.getMember_id());
					midto.setNicknameitem_name(parts1[1]);
					int on = service.onnick(midto);
				} else {
					if (parts1[1].equals(parts2[1])) {
						MyItemsDTO midto = new MyItemsDTO();
						midto.setMember_id(dto.getMember_id());
						midto.setNicknameitem_name(parts2[1]);
						int off = service.offnick(midto);
					} else {
						MyItemsDTO midto = new MyItemsDTO();
						midto.setMember_id(dto.getMember_id());
						midto.setNicknameitem_name(parts2[1]);
						int off = service.offnick(midto);
						midto.setNicknameitem_name(parts1[1]);
						int on = service.onnick(midto);
					}
				}
			}			
			RedirectView rv = new RedirectView();
			rv.setUrl("/mycustoms");
			mv.setView(rv);
			return mv;
		} else {
			RedirectView rv = new RedirectView();
			rv.setUrl("/login");
			mv.setView(rv);
			return mv;
		}
		
	}

}