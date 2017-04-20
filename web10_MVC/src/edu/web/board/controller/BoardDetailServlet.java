package edu.web.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.domain.BoardVO;
import edu.web.board.service.BoardService;
import edu.web.board.service.BoardServiceImple;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet(name = "boardDetail", urlPatterns = { "/board-detail" })
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        service = BoardServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardDetailServlet.doPost() 호출");
		
		// 쿼리 스트링에 포함된 요청 파라미터의 bno 값을 읽음
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// BoardService 객체의 read(bno) 호출
		BoardVO vo = service.read(bno);
		
		// 리턴 값에 따라서 결과 처리 -> JSP
		if(vo != null) { // DB에서 데이터를 정상적으로 읽은 경우
			request.setAttribute("boardVO", vo);
			request.getRequestDispatcher("/WEB-INF/board/board-detail.jsp").forward(request, response);
		} else {	// DB에서 데이터를 읽지 못한 경우
					
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
