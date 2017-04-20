package edu.web.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 클라이언트(브라우저)에게 응답(response)를 보내는
		// 문자열이 어떤 인코딩 타입을 사용하는 설정
		response.setCharacterEncoding("UTF-8");
		
		// 응답을 쓰기(write)위한 Writer 객체를 얻어옴
		PrintWriter writer = response.getWriter();
		
		// Writer 객체를 사용해서 응답 내용을 작성
		writer.append("<!doctype html>")
				.append("<html>")
				.append("<head>")
				.append("<meta charset='utf-8'/>")
				.append("<title>Servlet</title>")
				.append("</head>")
				.append("<body>")
				.append("<h1>안녕, 서블릿!</h1>")
				.append("</body>")
				.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
