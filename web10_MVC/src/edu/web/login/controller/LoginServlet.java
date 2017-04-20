package edu.web.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.member.service.MemberService;
import edu.web.member.service.MemberServiceImple;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        service = MemberServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� �ۼ����� �α����� �� �Ǿ� ���� ��, direct�� �������� doGet()�� ���� ���� �ϴ� ȣ��.
		// �״��� �α��ο��� submit�� ������ doPostȣ��!!
		// doPost���� �α��� �����ϸ�, targetURL Ȯ�� �� �α��� ���� ���� �������� �־����� Ȯ���� ���� �� �������� ����ش�.
		request.getRequestDispatcher("WEB-INF/login/login-form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("pwd");
		
		if(service.loginCheck(id, pw)) {
			// �α��� ���� -> ���� �Ӽ� ���� -> ������ �̵�
			HttpSession session = request.getSession();
			session.setAttribute("userid", id);
			session.setAttribute("pwd", pw);		
			String url = (String)session.getAttribute("targetURL");
			if(url != null && !url.equals("")){
				response.sendRedirect(url);
			} else {
				response.sendRedirect("board-main");
			}
			
		} else {
			// �α��� ���� -> �α��� ������
			response.sendRedirect("login");
		}		
	}
}
