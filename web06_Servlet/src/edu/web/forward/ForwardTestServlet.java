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
		System.out.println("forward doGet() 호출");
		// 웹에서 페이지 이동 방식:
		// 1. forward: URL 주소 유지. request/response 객체 유지
		//   같은 웹 서버 내에 있는 파일들로만 이동이 가능
		// 2. redirect: URL 주소 바뀜. request/response 객체 소멸
		//   같은 서버/다른 서버에 있는 페이지로 이동이 가능
		
		// forward 방식을 페이지를 이동할 때는
		// RequestDispatcher 인터페이스의 forward(req, res) 메소드를 사용
//		RequestDispatcher dispatcher =
//				request.getRequestDispatcher("index.jsp");
//		dispatcher.forward(request, response);
		
		// redirect 방식의 페이지 이동을 할 때는
		// response 클래스의 sendRedirect(dest) 메소드 호출
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
