package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.spring.ex04.domain.MemberVO;

public class LoginInterceptor 
	extends HandlerInterceptorAdapter {

	private static final Logger logger =
			LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 컨트롤러가 호출되기 전 호출
		logger.info("===== preHandle 호출");
		// targetUrl이 요청 매개변수(request parameter)가 있는 경우는
		// 세션에 그 정보를 저장
		String url = request.getParameter("targetUrl");
		if(url != null && url != "") {
			request.getSession().setAttribute("dest", url);
		}
		return true;
	}// end preHandle()
	
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHandle 호출");
		// Model 객체의 login_result 속성을 확인
		// null이 아니면(로그인 성공) Session 객체에 login_id 속성 추가, 페이지 이동
		// null이면(로그인 실패) 메인 페이지로 이동
		MemberVO vo = (MemberVO) 
				modelAndView.getModel().get("login_result");
		if (vo != null) {
			logger.info("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("login_id", vo.getUserid());
			session.removeAttribute("login_fail");
//			response.sendRedirect("/ex04");
			
			// 무조건 redirect 하지 말고, destination 을 보고 있으면 그 dest로 가고,
			// 없으면 원래 가려던 ex04로..
			String dest = (String)session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			} else {
				response.sendRedirect("/ex04");
			}
			
		} else {
			logger.info("로그인 실패");
			HttpSession session = request.getSession();
			session.setAttribute("login_fail", "fail");
			
			response.sendRedirect("/ex04");
		}
		
	} // end postHandle()
	
} // end class LoginInterceptor
















