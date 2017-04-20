package edu.web.board.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class BoardMainServlet
 */
@WebServlet(name = "boardmain", urlPatterns = { "/board-main" })
public class BoardMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Controller Service ��ü�� �޼ҵ带 ���
	private BoardService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardMainServlet() {
        super();
        // BoardService �ν��Ͻ��� ����
        service = BoardServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB ���� �Խñ� ����� �о�ͼ�(select) JSP���� ����
		
		List<BoardVO> list = service.read();
		System.out.println("BoardMainServlet : list size = " + list.size());
		request.setAttribute("boardList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/board-main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
