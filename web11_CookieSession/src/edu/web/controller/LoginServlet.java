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
		// 링크를 클릭하는거는 GET 방식
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		if(checkUser(userid, pwd)) {
			// 로그인 성공
			// 세션에 userid 속성을 저장 -> main 페이지로 redirect
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			response.sendRedirect("main");
		} else{
			// 로그인 실패
			// 이 경우에는 session에 값을 저장할 필요가 없기 때문에 바로 페이지를 보여준다
			response.sendRedirect("login");
			// 다시 로그인 페이지를 보여주자
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
