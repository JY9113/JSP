package edu.web.bean.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.bean.model.MyBean;

/**
 * Servlet implementation class beanTest
 */
@WebServlet(name = "/beanTest", urlPatterns = {"/beanTest"})
public class MyBeanTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBeanTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// MyBean Ŭ������ ����Ϸ��� ���� �ν��Ͻ��� ����
		MyBean bean1 = new MyBean();
		System.out.println("num = " + bean1.getMyNumber());
		System.out.println("name = " + bean1.getMyName());
		
		// Tomcat ������ �̸� ������ Mybean ��ü�� ����
		// JNDI : Java Naming and Directory Interface
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			MyBean bean2 = (MyBean) envContext.lookup("bean/MyBeanFactory");
			
			System.out.println("bean2 : " + bean2);
			System.out.println("bean2.number : " + bean2.getMyNumber());
			
			MyBean bean3 = (MyBean) envContext.lookup("bean/MyBeanFactory");
			System.out.println("bean3 : " + bean3);
			
			MyBean bean4 = (MyBean) envContext.lookup("bean/MyBeanFactory2");
			System.out.println("bean4 : " + bean4);
			System.out.println("bean4.number : " + bean4.getMyNumber());
			System.out.println("bean4.name : " + bean4.getMyName());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
