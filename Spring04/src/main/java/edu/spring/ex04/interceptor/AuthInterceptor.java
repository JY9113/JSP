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
		// register라는 controller메소드가 실행되기 전.
		// 로그인 상태를 체크 -> session에 로그인 정보가 있느냐 없느냐
		// 로그인 상태 : register 컨트롤러 메소드를 실행하면 된다. (return true)
		// 로그인 안 된 상태 : 로그인 양식으로 redirect, 컨트롤러 메소드는 실행하지 않도록 해야 한다.
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("login_id");
		if(userId != null && userId != ""){
			// 로그인 상태
			logger.info("로그인 상태 -> register(); 실행");
			// return true : 컨트롤러 메소드 실행
			return true;
		} else {
			// 로그인 안 된 상태
			logger.info("로그인 안 된 상태 ->  loginGet(); 실행");
			saveDestination(request);
			response.sendRedirect("../member/login");
			// return false : 컨트롤러를 실행 하지 않는다.
			// redirect를 하고 끝난다. loginGet()을 호출
			return false;
		}
	}
	
	private void saveDestination(HttpServletRequest request) {
		logger.info("saveDestination(); 호출");
		
		// 전체 요청 주소에서 쿼리 스트링을 제외한 부분만 가져오는게 getRequestURI
		String uri = request.getRequestURI();
		logger.info("요청 URI : " + uri);
		
		// 요청 주소에서 쿼리 스트링만 뽑아내는 함수(물음표 뒤쪽부터) : getQueryString();
		String queryString = request.getQueryString();
		logger.info("쿼리 스트링 : " +queryString);
		String url = "";
		if(queryString == null) {
			url = uri;
		} else {
			url = uri + "?" + queryString;
		}
		request.getSession().setAttribute("dest", url);
		
		
		
	}
	
	// controller 실행 다음 실행되는 함수
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
