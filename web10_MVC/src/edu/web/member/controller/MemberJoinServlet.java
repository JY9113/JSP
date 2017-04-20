package edu.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.member.domain.MemberVO;
import edu.web.member.service.MemberService;
import edu.web.member.service.MemberServiceImple;

/**
 * Servlet implementation class MemberJoinServlet
 */
@WebServlet(name = "memberJoin", urlPatterns = { "/member-join" })
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinServlet() {
        super();
        service = MemberServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/member-join.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String active = request.getParameter("active");
		
		MemberVO vo = new MemberVO(userid, pwd, email, active);
		int result = service.create(vo);
		if(result == 1) {
			response.sendRedirect("member-main");
		}
		
		
	
	}
	
}
