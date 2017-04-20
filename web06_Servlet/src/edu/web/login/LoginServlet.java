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
		System.out.println("login doGet() 호출");
		
		// 요청 파라미터(request parameter)의 값을 읽어옴
		// GET 방식에서는 요청 파라미터는 URL 주소의 query string에 포함되어 있음.
		// http://localhost:8181/web06/loginTest?userid=xxx&userpw=xxx
		//   http: 프로토콜
		//   localhost: 서버 주소(도메인 이름)
		//   8181: 포트 번호
		//   web06: context root(서버에서 파일을 찾아갈 수 있는 경로)
		//   loginTest: URL mapping
		//   ?userid=xxx&userpw=xxx: 쿼리 스트링
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		// 응답(response)의 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// Writer 객체를 얻어옴
		PrintWriter writer = response.getWriter();
		
		// 응답을 전송
		writer.append("<!DOCTYPE html>")
			.append("<html>")
			.append("<head><meta charset='utf-8' /></head>")
			.append("<body>")
			.append("<h1>로그인 결과</h1>")
			.append("USER ID: " + id + "<br/>")
			.append("USER PW: " + pw + "<br/>")
			.append("</body>")
			.append("</html>");
		
	} // end doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login doPost() 호출");
		
		// POST 방식에서는 요청 파라미터(request parameter)가
		// request 패킷의 body 부분에 포함되어 있음.
		// 요청 파라미터의 한글을 제대로 처리하기 위해서는
		// 인코딩 타입을 설정을 해야 함.
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	} // end doPost()

} // end class LoginServlet