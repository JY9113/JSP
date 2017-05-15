package edu.spring.ex03;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex03.domain.ReplyVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	/*responsebody�� �Ƿ��� client�� �ٷ� ���޵ȴ�*/
	public String test() {
		return "test<br/>test";
	}
	
	@RequestMapping(value="/test2", method = RequestMethod.GET)
	@ResponseBody
	/* ReplyVO�� return �� �� �����Ƿ� responsebody�� �־..*/
	public ReplyVO test2() {
		/*jacskon databind ���п� ���ϴ� Ÿ���� ���̽� �������� ���� �� �ִ�*/
		ReplyVO vo = new ReplyVO(111, 22, "�׽�Ʈ", "jy", new Date());
		return vo;
	}
	
}
