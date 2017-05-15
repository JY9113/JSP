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
		// ��Ʈ�ѷ��� ȣ��Ǳ� �� ȣ��
		logger.info("===== preHandle ȣ��");
		// targetUrl�� ��û �Ű�����(request parameter)�� �ִ� ����
		// ���ǿ� �� ������ ����
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
		logger.info("===== postHandle ȣ��");
		// Model ��ü�� login_result �Ӽ��� Ȯ��
		// null�� �ƴϸ�(�α��� ����) Session ��ü�� login_id �Ӽ� �߰�, ������ �̵�
		// null�̸�(�α��� ����) ���� �������� �̵�
		MemberVO vo = (MemberVO) 
				modelAndView.getModel().get("login_result");
		if (vo != null) {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("login_id", vo.getUserid());
			session.removeAttribute("login_fail");
//			response.sendRedirect("/ex04");
			
			// ������ redirect ���� ����, destination �� ���� ������ �� dest�� ����,
			// ������ ���� ������ ex04��..
			String dest = (String)session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			} else {
				response.sendRedirect("/ex04");
			}
			
		} else {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("login_fail", "fail");
			
			response.sendRedirect("/ex04");
		}
		
	} // end postHandle()
	
} // end class LoginInterceptor
















