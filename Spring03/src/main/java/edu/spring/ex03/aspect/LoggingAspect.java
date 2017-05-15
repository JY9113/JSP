package edu.spring.ex03.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component          // Proxy 객체에 주입(inject)하기 위해서 (bean으로 관리가 되어야 inject가 가능해진다)
@Aspect          //Aspect = Advice + Pointcut
public class LoggingAspect {

   private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
   
   
   @Before("execution(* edu.spring.ex03.service.CustomerServiceImple.*Customer(..) )")
   // 포인트 컷을 지정한다. 
   // *는 createCustomer의 리턴타입을 말한다. void라고 해도 된다.
   // (..)는 메소드의 매개변수를 의미하며, ..은 매개변수가 어떤것이 오던지 상관없다는 뜻이다.

   // createCustomer를 *Customer(..)라고 작성해도 가능하다. 


   public void beforeAdvice(JoinPoint jp){ //joinpoint는 실제 pointcut에 대한 정보를 말한다.
      logger.info("=====beforeAdvice");
      logger.info("target : " + jp.getTarget()); 
      logger.info("signature: " + jp.getSignature());
      // 서버를 다시 재생하면 createCustomer()라는 메소드의 호출을 가로채서 , 이것이 시작되기 직전에 들어가서
      // beforeAdvice가 실행하겠다는 뜻으로 화살표 모양이 생긴다. 

   }//end beforeAdvice
   
   
   
   @After("execution(* edu.spring.ex03.service.CustomerService*.create*(..) )")
   public void afterAdvice(){
      logger.info("=====afterAdvice");
   }
   
   
   
   @AfterReturning("execution(* edu.spring.ex03.service.CustomerService*.create*(..) )")
   public void afterReturningAdvice(){
      logger.info("=====afterReturningAdvice");
   }
   
   
   
   @AfterThrowing("execution(* edu.spring.ex03.service.CustomerService*.create*(..) )")
   public void afterThrowingAdvice(){
      logger.info("===== afterThrowingAdvice");
   }
   
   
}//end class LoggingAspect