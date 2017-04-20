package edu.web.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.board.domain.BoardVO;
import edu.web.board.service.BoardService;
import edu.web.board.service.BoardServiceImple;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet(
		name = "boardInsert", 
		urlPatterns = { "/board-insert" }
)
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService service;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        service = BoardServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체에서 로그인 정보가 있는지 확인.
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userid");
		
		if(id != null && !id.equals("")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/board-insert-form.jsp");
			dispatcher.forward(request, response);
		} else {
			// 로그인 정보가 없어서 로그인하러 가야함.
			// 로그인 후에 다시 띄워 줄 페이지 정보를 세션에 attr 로 저장해서 보내자.
			session.setAttribute("targetURL", "board-insert");
			response.sendRedirect("login");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("boardInsertServlet.doPost() 호출");
		
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userid = request.getParameter("userid");
		BoardVO vo = new BoardVO(0, title, content, userid, null);
		
		// BoardService 객체의 create 메소드를 호출
		int result = service.create(vo);
		
		// result 출력
		System.out.println("게시글 작성 결과 : " + result);
		
		if(result == 1) { // DB INSERT 성공
			// 게시글 목록(메인) 페이지로 redirect
			response.sendRedirect("board-main");
		} else {	// DB INSERT 실패
			
		}
	}

}
