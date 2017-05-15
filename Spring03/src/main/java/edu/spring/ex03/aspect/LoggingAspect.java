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

@Component          // Proxy ��ü�� ����(inject)�ϱ� ���ؼ� (bean���� ������ �Ǿ�� inject�� ����������)
@Aspect          //Aspect = Advice + Pointcut
public class LoggingAspect {

   private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
   
   
   @Before("execution(* edu.spring.ex03.service.CustomerServiceImple.*Customer(..) )")
   // ����Ʈ ���� �����Ѵ�. 
   // *�� createCustomer�� ����Ÿ���� ���Ѵ�. void��� �ص� �ȴ�.
   // (..)�� �޼ҵ��� �Ű������� �ǹ��ϸ�, ..�� �Ű������� ����� ������ ������ٴ� ���̴�.

   // createCustomer�� *Customer(..)��� �ۼ��ص� �����ϴ�. 


   public void beforeAdvice(JoinPoint jp){ //joinpoint�� ���� pointcut�� ���� ������ ���Ѵ�.
      logger.info("=====beforeAdvice");
      logger.info("target : " + jp.getTarget()); 
      logger.info("signature: " + jp.getSignature());
      // ������ �ٽ� ����ϸ� createCustomer()��� �޼ҵ��� ȣ���� ����ä�� , �̰��� ���۵Ǳ� ������ ����
      // beforeAdvice�� �����ϰڴٴ� ������ ȭ��ǥ ����� �����. 

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