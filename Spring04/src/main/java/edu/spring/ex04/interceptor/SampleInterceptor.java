package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor 
	extends HandlerInterceptorAdapter {

	private static final Logger logger =
			LoggerFactory.getLogger(SampleInterceptor.class);
	
	// ��û(request)�� �ش��ϴ� ��Ʈ�ѷ� �޼ҵ尡 �����ϱ� ����
	// ��û�� ����ä�� �ؾ� �� ��ɵ��� �ۼ�
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandle ȣ��");
		
		return super.preHandle(request, response, handler);
	}
	
	// ��Ʈ�ѷ� �޼ҵ尡 ����� ���Ŀ�,
	// DispatcherServlet�� View(JSP)�� ó���ϱ� ����
	// �ؾ��� ��ɵ��� �ۼ�
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHandle ȣ��");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// DispatcherServlet�� ���ؼ� ȭ�� ó��(View, JSP)�� ���� �Ŀ�
	// �ؾ� �� ��ɵ��� �ۼ�
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, 
			Exception ex)
			throws Exception {
		logger.info("===== afterCompletion ȣ��");
		
		super.afterCompletion(request, response, handler, ex);
	}
	
} // end class SampleInterceptor

















