package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.pageutil.PageMaker;
import edu.spring.ex02.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model, Integer page, Integer perPage) {
		logger.info("list() 호출");
		// paging 처리 이전 코드
//		List<BoardVO> list = boardService.read();
//		model.addAttribute("boardList", list);
		
		// paging 처리
		PageCriteria c = new PageCriteria();
		if (page != null) {
			c.setPage(page);
		}
		if (perPage != null) {
			c.setNumsPerPage(perPage);
		}
		// 한페이지에 보여질 리스트만 가져옴.
		List<BoardVO> list = boardService.read(c);
		model.addAttribute("boardList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		maker.setTotalCount(boardService.getTotalNumsOfRecords());
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() {
		logger.info("registerGET() 호출");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) {
		logger.info("registerPOST() 호출");
		logger.info("제목: " + vo.getTitle());
		logger.info("본문: " + vo.getContent());
		logger.info("아이디: " + vo.getUserid());
		int result = boardService.create(vo);
		if (result == 1) { // DB insert 성공
			reAttr.addFlashAttribute("insert_result", "success");
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
		}
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detail(int bno, Model model, @ModelAttribute("criteria") PageCriteria c) {
		logger.info("detail() 호출: bno=" + bno);
		BoardVO vo = boardService.read(bno);
		model.addAttribute("boardVO", vo);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update(int bno, Model model, @ModelAttribute("criteria") PageCriteria c) {
		logger.info("update() 호출: bno=" + bno);
		BoardVO vo = boardService.read(bno);
		model.addAttribute("boardVO", vo);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updatePOST(BoardVO vo, PageCriteria c){
		logger.info("updatePOST(); 호출 bno = " + vo.getBno());
		int result = boardService.update(vo);
		
		return "redirect:/board/list?page=" + c.getPage() + "&perPage=" + c.getNumsPerPage();
		// 업데이트가 끝나면 board/list로 다시 돌아간다.	
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(int bno) {
		logger.info("delete(); 호출 bno = " + bno);
		int result = boardService.delete(bno);
		
		return "redirect:/board/list";
	}

} // end class BoardController
