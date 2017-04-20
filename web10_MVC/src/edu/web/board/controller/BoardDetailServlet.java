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
		System.out.println("BoardDetailServlet.doPost() ȣ��");
		
		// ���� ��Ʈ���� ���Ե� ��û �Ķ������ bno ���� ����
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// BoardService ��ü�� read(bno) ȣ��
		BoardVO vo = service.read(bno);
		
		// ���� ���� ���� ��� ó�� -> JSP
		if(vo != null) { // DB���� �����͸� ���������� ���� ���
			request.setAttribute("boardVO", vo);
			request.getRequestDispatcher("/WEB-INF/board/board-detail.jsp").forward(request, response);
		} else {	// DB���� �����͸� ���� ���� ���
					
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
