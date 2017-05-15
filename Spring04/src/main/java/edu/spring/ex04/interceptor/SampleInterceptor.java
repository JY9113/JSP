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
	
	// 요청(request)에 해당하는 콘트롤러 메소드가 동작하기 전에
	// 요청을 가로채서 해야 할 기능들을 작성
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandle 호출");
		
		return super.preHandle(request, response, handler);
	}
	
	// 콘트롤러 메소드가 수행된 이후에,
	// DispatcherServlet이 View(JSP)를 처리하기 전에
	// 해야할 기능들을 작성
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHandle 호출");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// DispatcherServlet에 의해서 화면 처리(View, JSP)가 끝난 후에
	// 해야 할 기능들을 작성
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, 
			Exception ex)
			throws Exception {
		logger.info("===== afterCompletion 호출");
		
		super.afterCompletion(request, response, handler, ex);
	}
	
} // end class SampleInterceptor

















