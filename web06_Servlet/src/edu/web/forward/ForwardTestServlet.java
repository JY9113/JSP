package edu.web.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardTestServlet
 */
@WebServlet("/forward")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forward doGet() ȣ��");
		// ������ ������ �̵� ���:
		// 1. forward: URL �ּ� ����. request/response ��ü ����
		//   ���� �� ���� ���� �ִ� ���ϵ�θ� �̵��� ����
		// 2. redirect: URL �ּ� �ٲ�. request/response ��ü �Ҹ�
		//   ���� ����/�ٸ� ������ �ִ� �������� �̵��� ����
		
		// forward ����� �������� �̵��� ����
		// RequestDispatcher �������̽��� forward(req, res) �޼ҵ带 ���
//		RequestDispatcher dispatcher =
//				request.getRequestDispatcher("index.jsp");
//		dispatcher.forward(request, response);
		
		// redirect ����� ������ �̵��� �� ����
		// response Ŭ������ sendRedirect(dest) �޼ҵ� ȣ��
		response.sendRedirect("http://www.google.com");
	} // end doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
