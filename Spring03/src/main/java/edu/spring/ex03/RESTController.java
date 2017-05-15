package edu.spring.ex03;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.service.ReplyService;

@RestController
// @RestController�� ����� Ŭ������ ��� �޼ҵ����
// �� ���� ������ View(JSP) ������ �̸��� �ǹ��ϴ� ���� �ƴ϶�,
// ResponseBody�� ���ԵǼ� Ŭ���̾�Ʈ���� ���� ���޵�
// @RestController�� �޼ҵ�鿡�� @ResponseBody ������̼��� ������� ����
// @RestController�� ������ 4 �������� ����
public class RESTController {

	@Autowired
	private ReplyService service;
	
	@RequestMapping(value = "/rest1",
			method = RequestMethod.GET)
	public String rest1() {
		
		return "Hello, REST Controller!";
	}
	
	@RequestMapping(value = "/rest2",
			method = RequestMethod.GET)
	public List<ReplyVO> rest2() {
		return service.read(1);
	}
	
	@RequestMapping(value = "/rest3",
			method = RequestMethod.GET)
	public ResponseEntity<ReplyVO> rest3() {
		ReplyVO vo = new ReplyVO(11,
				22,
				"��� Ajax REST �׽�Ʈ",
				"admin",
				new Date());
		ResponseEntity<ReplyVO> entity =
				new ResponseEntity<ReplyVO>(vo, HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/rest4",
			method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> rest4() {
		List<ReplyVO> list = service.read(1);
		ResponseEntity<List<ReplyVO>> entity =
				new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}
	
} // end class RESTController