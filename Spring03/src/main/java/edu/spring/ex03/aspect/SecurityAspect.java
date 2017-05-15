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
public class SecurityAspect {

   private static final Logger logger =    LoggerFactory.getLogger(SecurityAspect.class);
   
   
   // (2) 포인트 컷을 지정하는 2번째 방법
   
   // 1. @Before, @After, ... 어노테이션 안에서 지정하는 방법
   // 2. @Pointcut 어노테이션 안에서 지정하는 방법 
   // 1번의 방법은 여러개의 advice 메소드들이 하나의 포인트컷에 가고 있는데, 포인트 컷을 일일히 복붙해야 하는 번거로움이 있다.
   // 2번의 방법을 이용하여, pointcut을 하나의 상수로 정의할 수 있다. 
   
   // (주석정리)
   // -> 동일한 pointcut이 반복되는 것을 피할 수 있음
   // -> 한 번 지정한 pointcut을 여러 advice 메소드에서 참조
   @Pointcut("execution(* edu.spring.ex03.service.Customer*.update*(..))")
   public void updateAdvice(){}
   // 실제로 함수로 만드는 것이 아니라, 이렇게 정의한 포인트 컷을 updateAdvice로 참조하겠다고 비어있는 함수 형태로 이름만 주는 것이다. 
   // 이렇게 만든 포인트 컷은 before, after, around 다 쓸 수 있다.
   
   
   
   @Around("updateAdvice()")
   public Object aroundAdvice(ProceedingJoinPoint jp){
      // 여기서는 joinpoint라고 하지 않고, ProceedingJoinPoint라고 했다.
      // 왜냐하면 target이 되는 메소드를 언제 실행해야 할지는 우리가 정하는 건데 그게 jp.proceed() 이며
      // jointpoint는 이 메소드를 가지고 있지 않고, ProceedingJoinPoint만 가지고 있다.
      
      //jp가 어떤 것을 return 할지 모르므로 object로 참조변수 작성.
      
      Object result = null;
       try {
          // @Before 에서 할 기능들 작성
          logger.info("=====메소드 호출 전");
          
          // target의 pointcut 메소드를 호출. 
          // Around 메소드 ㅠㅠ잊어버리지 말자 ㅠㅠ
          result = jp.proceed();
          
          // @AfterRetruning에서 할 기능들 작성 (정상적으로 return 받았을 때)
          logger.info("=====메소드 리턴 후");          
              
          
          
       } catch(Throwable e) {          
          // @AfterThrowing에서 해야 할 기능 작성
          logger.info("=====메소드 실행 중 예외 발생");
                 
       } finally {          
          // @After에서 해야 할 기능을 작성(무조건 하는 부분)
          logger.info("=====finally 실행");
       }        
       
      return result;
      // result = jp.proceed();를 호출하지 않으면
      // 1이 return 되지 않고, null을 리턴받아 exception이 발생한다.
   }
   
   
   
}//end class SecurityAspect