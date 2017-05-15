package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.ex01.domain.ProductVO;

@Controller
public class SampleVOController {
	private static final Logger logger =
			LoggerFactory.getLogger(SampleVOController.class);
	
	@RequestMapping(value = "/product1")
	public String testProduct1(Model model, 
			String pname, int price) {
		logger.info("testProduct1() ȣ��");
		logger.info("pname: " + pname);
		logger.info("price: " + price);
		ProductVO vo = new ProductVO(pname, price);
		model.addAttribute("product", vo);
		
		return "product-result";
	}
	
	@RequestMapping(value="/product2")
	public String testProduct2(@ModelAttribute(name="product") ProductVO vo) {
		logger.info("testProduct2(); ȣ��");
		logger.info("pname : " + vo.getPname());
		logger.info("price : " + vo.getPrice());
		return "product-result";
	}
	
} // end SampleVOController














