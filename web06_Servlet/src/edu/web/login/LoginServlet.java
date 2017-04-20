package edu.web.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginTest")
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
		System.out.println("login doGet() ȣ��");
		
		// ��û �Ķ����(request parameter)�� ���� �о��
		// GET ��Ŀ����� ��û �Ķ���ʹ� URL �ּ��� query string�� ���ԵǾ� ����.
		// http://localhost:8181/web06/loginTest?userid=xxx&userpw=xxx
		//   http: ��������
		//   localhost: ���� �ּ�(������ �̸�)
		//   8181: ��Ʈ ��ȣ
		//   web06: context root(�������� ������ ã�ư� �� �ִ� ���)
		//   loginTest: URL mapping
		//   ?userid=xxx&userpw=xxx: ���� ��Ʈ��
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		// ����(response)�� �ѱ� ó��
		response.setCharacterEncoding("UTF-8");
		
		// Writer ��ü�� ����
		PrintWriter writer = response.getWriter();
		
		// ������ ����
		writer.append("<!DOCTYPE html>")
			.append("<html>")
			.append("<head><meta charset='utf-8' /></head>")
			.append("<body>")
			.append("<h1>�α��� ���</h1>")
			.append("USER ID: " + id + "<br/>")
			.append("USER PW: " + pw + "<br/>")
			.append("</body>")
			.append("</html>");
		
	} // end doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login doPost() ȣ��");
		
		// POST ��Ŀ����� ��û �Ķ����(request parameter)��
		// request ��Ŷ�� body �κп� ���ԵǾ� ����.
		// ��û �Ķ������ �ѱ��� ����� ó���ϱ� ���ؼ���
		// ���ڵ� Ÿ���� ������ �ؾ� ��.
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	} // end doPost()

} // end class LoginServlet