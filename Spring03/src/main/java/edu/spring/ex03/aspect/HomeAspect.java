package edu.spring.ex03.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HomeAspect {

	private static final Logger logger =
			LoggerFactory.getLogger(HomeAspect.class);
	
	@Pointcut("execution(* edu.spring.ex03.HomeController.home(..))")
	public void pcHome() {}
	
	@Around("pcHome()")
	public Object homeAdvice(ProceedingJoinPoint jp) {
		Object result = null;
		
		logger.info("===== homeAdvice");
		try {
			logger.info("===== home() 호출 전"); 
			result = jp.proceed();
			logger.info("===== home() 리턴 후: " + result);
		} catch (Throwable e) {
			logger.info("===== 예외 발생: " + e.getMessage());
		} finally {
			logger.info("===== finally");
		}
		
		return "reply";
	} // end homeAdvice()
	
} // end class HomeAspect