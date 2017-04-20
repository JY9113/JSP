package edu.web.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet(urlPatterns = {"/LifeCycleServlet"}, loadOnStartup=1)

// Servlet 설정 property 중에서 loadOnStartup :
// 	서버가 실행될 때 서블릿 인스턴스를 메모리에 로드하는 우선 순위를 설정하는 프로퍼티
// 	숫자가 작을수록 우선 순위가 높다. 
// 	ex) 1이면 서버 시작하자 바로 load

public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		// TODO Auto-generated method stub
		response.getWriter().append("<h1>Life cycle</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		doGet(request, response);
	}
	
	// Servlet Life Cycle 메소드
	// init() : Servlet 인스턴스가 생성된 후 ( = 생성자가 불린 이후)
	// 		   초기화 작업을 위해서 호출되는 생명주기 메소드
	//			   특별한 Servlet 설정이 없으면,
	//  		   최초 요청(request)가 있을 때 init() 메소드가 호출됨.
	// 		   Servlet 설정에서 loadOnStartup을 설정하면
	// 		   우선 순위에 따라서 서버가 실행될 때 init() 메소드가 호출됨.
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출");
	}

	
	// Servlet이 종료 될 때 호출되는 생명주기 메소드
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
}
