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
// ex04/replies (POST) : 댓글 추가(insert)
// ex04/replies/all/숫자(GET) : 해당 글번호(bno)의 모든 댓글 검색(select)
//   "   /replies/숫자 (PUT) : 해당 댓글 번호(rno)의 내용을 수정(update)
//	  "   /replies/숫자 (DELETE) : 해당 댓글 번호(rno)의 댓글을 삭제

@RestController
@RequestMapping(value = "/replies")
public class ReplyRESTController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyRESTController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO vo) {
		/*requestBody 에 포함되어 있는것을 ReplyVO로 반환해 주세요*/
		
		int result = replyService.create(vo);
		ResponseEntity<Integer> entity = new ResponseEntity<>(result, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value="/all/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> readReplies(@PathVariable("no") int bno) {
		/*int bno값이 {no}에 들어간다.
		 *  no가 Variable 이름, Path중 일부를 Variable로 사용하겠다. 
		 *  PathVariable중 "no"라는 이름을 가진 variable의 값을 bno에 넣어주겠다
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
