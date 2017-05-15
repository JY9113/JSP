package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("");
		// register��� controller�޼ҵ尡 ����Ǳ� ��.
		// �α��� ���¸� üũ -> session�� �α��� ������ �ִ��� ������
		// �α��� ���� : register ��Ʈ�ѷ� �޼ҵ带 �����ϸ� �ȴ�. (return true)
		// �α��� �� �� ���� : �α��� ������� redirect, ��Ʈ�ѷ� �޼ҵ�� �������� �ʵ��� �ؾ� �Ѵ�.
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("login_id");
		if(userId != null && userId != ""){
			// �α��� ����
			logger.info("�α��� ���� -> register(); ����");
			// return true : ��Ʈ�ѷ� �޼ҵ� ����
			return true;
		} else {
			// �α��� �� �� ����
			logger.info("�α��� �� �� ���� ->  loginGet(); ����");
			saveDestination(request);
			response.sendRedirect("../member/login");
			// return false : ��Ʈ�ѷ��� ���� ���� �ʴ´�.
			// redirect�� �ϰ� ������. loginGet()�� ȣ��
			return false;
		}
	}
	
	private void saveDestination(HttpServletRequest request) {
		logger.info("saveDestination(); ȣ��");
		
		// ��ü ��û �ּҿ��� ���� ��Ʈ���� ������ �κи� �������°� getRequestURI
		String uri = request.getRequestURI();
		logger.info("��û URI : " + uri);
		
		// ��û �ּҿ��� ���� ��Ʈ���� �̾Ƴ��� �Լ�(����ǥ ���ʺ���) : getQueryString();
		String queryString = request.getQueryString();
		logger.info("���� ��Ʈ�� : " +queryString);
		String url = "";
		if(queryString == null) {
			url = uri;
		} else {
			url = uri + "?" + queryString;
		}
		request.getSession().setAttribute("dest", url);
		
		
		
	}
	
	// controller ���� ���� ����Ǵ� �Լ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
