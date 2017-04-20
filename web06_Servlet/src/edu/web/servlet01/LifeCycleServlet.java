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

// Servlet ���� property �߿��� loadOnStartup :
// 	������ ����� �� ���� �ν��Ͻ��� �޸𸮿� �ε��ϴ� �켱 ������ �����ϴ� ������Ƽ
// 	���ڰ� �������� �켱 ������ ����. 
// 	ex) 1�̸� ���� �������� �ٷ� load

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
		System.out.println("doGet() ȣ��");
		// TODO Auto-generated method stub
		response.getWriter().append("<h1>Life cycle</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ȣ��");
		doGet(request, response);
	}
	
	// Servlet Life Cycle �޼ҵ�
	// init() : Servlet �ν��Ͻ��� ������ �� ( = �����ڰ� �Ҹ� ����)
	// 		   �ʱ�ȭ �۾��� ���ؼ� ȣ��Ǵ� �����ֱ� �޼ҵ�
	//			   Ư���� Servlet ������ ������,
	//  		   ���� ��û(request)�� ���� �� init() �޼ҵ尡 ȣ���.
	// 		   Servlet �������� loadOnStartup�� �����ϸ�
	// 		   �켱 ������ ���� ������ ����� �� init() �޼ҵ尡 ȣ���.
	@Override
	public void init() throws ServletException {
		System.out.println("init() ȣ��");
	}

	
	// Servlet�� ���� �� �� ȣ��Ǵ� �����ֱ� �޼ҵ�
	
	@Override
	public void destroy() {
		System.out.println("destroy() ȣ��");
	}
}
