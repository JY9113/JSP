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
		// 새글 작성에서 로그인이 안 되어 있을 때, direct로 보내오면 doGet()이 제일 먼저 일단 호출.
		// 그다음 로그인에서 submit을 누르면 doPost호출!!
		// doPost에서 로그인 성공하면, targetURL 확인 후 로그인 전에 무슨 페이지에 있었는지 확인한 다음 그 페이지를 띄워준다.
		request.getRequestDispatcher("WEB-INF/login/login-form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("pwd");
		
		if(service.loginCheck(id, pw)) {
			// 로그인 성공 -> 세션 속성 저장 -> 페이지 이동
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
			// 로그인 실패 -> 로그인 페이지
			response.sendRedirect("login");
		}		
	}
}
