package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ũ�� Ŭ���ϴ°Ŵ� GET ���
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		if(checkUser(userid, pwd)) {
			// �α��� ����
			// ���ǿ� userid �Ӽ��� ���� -> main �������� redirect
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			response.sendRedirect("main");
		} else{
			// �α��� ����
			// �� ��쿡�� session�� ���� ������ �ʿ䰡 ���� ������ �ٷ� �������� �����ش�
			response.sendRedirect("login");
			// �ٽ� �α��� �������� ��������
		}
	}
	
	private boolean checkUser(String id, String pw) {
		if (id.equals("admin") && pw.equals("1234")) {
			return true;
		} else {
			return false;
		}			
	}

}
