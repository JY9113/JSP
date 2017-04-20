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
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/board/board-insert-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("boardInsertServlet.doPost() ȣ��");
		
		
		// �ѱ� ó��
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userid = request.getParameter("userid");
		BoardVO vo = new BoardVO(0, title, content, userid, null);
		
		// BoardService ��ü�� create �޼ҵ带 ȣ��
		int result = service.create(vo);
		
		// result ���
		System.out.println("�Խñ� �ۼ� ��� : " + result);
		
		if(result == 1) { // DB INSERT ����
			// �Խñ� ���(����) �������� redirect
			response.sendRedirect("board-main");
		} else {	// DB INSERT ����
			
		}
	}

}
