package edu.spring.ex03.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.service.ReplyService;

// RequestMapping
// ex04/replies (POST) : ��� �߰�(insert)
// ex04/replies/all/����(GET) : �ش� �۹�ȣ(bno)�� ��� ��� �˻�(select)
//   "   /replies/���� (PUT) : �ش� ��� ��ȣ(rno)�� ������ ����(update)
//	  "   /replies/���� (DELETE) : �ش� ��� ��ȣ(rno)�� ����� ����

@RestController
@RequestMapping(value = "/replies")
public class ReplyRESTController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyRESTController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO vo) {
		/*requestBody �� ���ԵǾ� �ִ°��� ReplyVO�� ��ȯ�� �ּ���*/
		
		int result = replyService.create(vo);
		ResponseEntity<Integer> entity = new ResponseEntity<>(result, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value="/all/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> readReplies(@PathVariable("no") int bno) {
		/*int bno���� {no}�� ����.
		 *  no�� Variable �̸�, Path�� �Ϻθ� Variable�� ����ϰڴ�. 
		 *  PathVariable�� "no"��� �̸��� ���� variable�� ���� bno�� �־��ְڴ�
		 * */
		List<ReplyVO> list = replyService.read(bno);
		ResponseEntity<List<ReplyVO>> entity = new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value="/{no}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(@PathVariable("no") int rno, @RequestBody ReplyVO vo) {
		vo.setRno(rno);
		int result = replyService.update(vo);
		ResponseEntity<String> entity = null;
		if(result == 1) {
			entity = new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>("Fail", HttpStatus.OK);
		}
		
		return entity;
		
	}
	@RequestMapping(value="/{no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReplay(@PathVariable("no") int rno) {
		int result = replyService.delete(rno);
		ResponseEntity<String> entity = null;
		if(result == 1) {
			entity = new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>("Fail", HttpStatus.OK);
		}
		return entity;
	}	
}
