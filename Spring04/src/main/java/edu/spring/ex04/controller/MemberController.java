package edu.spring.ex04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex04.domain.MemberVO;
import edu.spring.ex04.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login-post",
			method = RequestMethod.POST)
	public void loginPost(MemberVO vo, Model model) {
		logger.info(vo.getUserid() + ", "
				+ vo.getPwd() + ", "
				+ vo.getEmail() + ", "
				+ vo.getActive());
		MemberVO result = memberService.loginCheck(vo);
		model.addAttribute("login_result", result);
	}
	
	@RequestMapping(value = "/logout",
			method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		logger.info("logout() ȣ��");
		
		HttpSession session = req.getSession();
		session.removeAttribute("login_id");
		session.invalidate();
		// session.invalidate �� ������, �α׾ƿ� ��å�� ������ �Ѵ�.
		// return "redirect:/member/login" ���ָ� �α׾ƿ��ϸ� �׻� �α��� ������ ���ư���.
		return "redirect:/";
	}
	

	@RequestMapping(value = "/login",
			method = RequestMethod.GET)
	public void loginGet(String url, Model model) {
		logger.info("loginGet() ȣ��");
		logger.info("url: " + url);
		model.addAttribute("targetUrl", url);
	}
	
} // end class MemberController
