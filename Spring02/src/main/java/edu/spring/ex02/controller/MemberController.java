package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex02.domain.MemberVO;
import edu.spring.ex02.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member_list", method=RequestMethod.GET)
	public void list(Model model) {
		logger.info("member list(); 호출");
		List<MemberVO> memberList = memberService.read_all();
		model.addAttribute("memberList", memberList);
	}
	
	@RequestMapping(value="member_insert", method=RequestMethod.GET)
	public void insert() {
		logger.info("member insert(); 호출");
	}
	
	@RequestMapping(value="member_insert", method=RequestMethod.POST)
	public String insertPOST(MemberVO vo, RedirectAttributes reAttr) {
		logger.info("member insertPOST(); 호출");
		int result = memberService.create_member(vo);
		if(result == 1) {
			reAttr.addFlashAttribute("member_insert_result", "SUCCESS");
		} else {
			reAttr.addFlashAttribute("member_insert_result", "FAIL");
		}		
		return "redirect:/member/member_list";
	}
	
	@RequestMapping(value="/member_detail", method=RequestMethod.GET)
	public void detail(String userid, Model model) {
		logger.info("member read(); 호출");
		MemberVO vo= memberService.read_member(userid);
		model.addAttribute("memberVO", vo);		
	}
	
	@RequestMapping(value="/member_update", method=RequestMethod.GET)
	public void update(String userid, Model model) {
		logger.info("member update(); 호출");
		MemberVO vo = memberService.read_member(userid);
		model.addAttribute("memberVO", vo);
	}
	
	@RequestMapping(value="/member_update", method=RequestMethod.POST)
	public String updatePOST(MemberVO vo) {
		logger.info("member updatePOST(); 호출");
		int result = memberService.update(vo);
		return "redirect:/member/member_list";
	}
	
	@RequestMapping(value="/member_delete", method=RequestMethod.POST)
	public String delete(String userid) {
		logger.info("member delete(); 호출");
		int result = memberService.delete(userid);
		return "redirect:/member/member_list";
	}
}
