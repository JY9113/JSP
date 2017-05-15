package edu.spring.ex04.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor2 	extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SampleInterceptor2.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandler ȣ��");
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		logger.info("Bean : " + handlerMethod.getBean());
		logger.info("method : " + method.getName());
		
		return true;
		// preHandle()�� ���ϰ��� �ǹ�
		// true : ���� �����Ϸ� �ߴ� ��Ʈ�ѷ� �޼ҵ带 ����
		// false : ��Ʈ�ѷ� �޼ҵ带 �������� ����
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHandler ȣ��");
		String data = (String)modelAndView.getModel().get("data");
		logger.info("data : " + data);
		if (data == null) {
			HttpSession session = request.getSession();
			session.setAttribute("data",  "DUMMY DATA");
			
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("===== afterCompletion ȣ��");
		super.afterCompletion(request, response, handler, ex);
	}
	
} // end class SampleInterceptor2














