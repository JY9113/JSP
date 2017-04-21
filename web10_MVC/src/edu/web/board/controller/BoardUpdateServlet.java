package edu.web.board.controller;

import java.io.IOException;
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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet(name = "boardUpdate", urlPatterns = { "/board-update" })
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        service = BoardServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("userid");
		String writer = request.getParameter("boardVO");
		System.out.println("writer : " + writer);
		if(id.equals(writer)) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardVO vo = service.read(bno);
			if (vo != null) {
				request.setAttribute("boardVO", vo);
				request.getRequestDispatcher("/WEB-INF/board/board-update.jsp").forward(request, response);			
			}
		} else {
			response.sendRedirect("board-main");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardVO vo = new BoardVO(bno, title, content, null, null);
		
		int result = service.update(vo);
		if(result == 1) {
			response.sendRedirect("board-detail?bno=" + vo.getBno());
		} else {
			
			
		}
	}

}
