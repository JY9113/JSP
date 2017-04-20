package edu.web.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.service.BoardService;
import edu.web.board.service.BoardServiceImple;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet(name = "boardDelete", urlPatterns = { "/board-delete" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        service = BoardServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int result = service.delete(bno);
		if(result==1) {
			response.sendRedirect("board-main");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
