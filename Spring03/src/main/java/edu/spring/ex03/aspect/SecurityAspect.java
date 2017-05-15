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
   
   
   // (2) ����Ʈ ���� �����ϴ� 2��° ���
   
   // 1. @Before, @After, ... ������̼� �ȿ��� �����ϴ� ���
   // 2. @Pointcut ������̼� �ȿ��� �����ϴ� ��� 
   // 1���� ����� �������� advice �޼ҵ���� �ϳ��� ����Ʈ�ƿ� ���� �ִµ�, ����Ʈ ���� ������ �����ؾ� �ϴ� ���ŷο��� �ִ�.
   // 2���� ����� �̿��Ͽ�, pointcut�� �ϳ��� ����� ������ �� �ִ�. 
   
   // (�ּ�����)
   // -> ������ pointcut�� �ݺ��Ǵ� ���� ���� �� ����
   // -> �� �� ������ pointcut�� ���� advice �޼ҵ忡�� ����
   @Pointcut("execution(* edu.spring.ex03.service.Customer*.update*(..))")
   public void updateAdvice(){}
   // ������ �Լ��� ����� ���� �ƴ϶�, �̷��� ������ ����Ʈ ���� updateAdvice�� �����ϰڴٰ� ����ִ� �Լ� ���·� �̸��� �ִ� ���̴�. 
   // �̷��� ���� ����Ʈ ���� before, after, around �� �� �� �ִ�.
   
   
   
   @Around("updateAdvice()")
   public Object aroundAdvice(ProceedingJoinPoint jp){
      // ���⼭�� joinpoint��� ���� �ʰ�, ProceedingJoinPoint��� �ߴ�.
      // �ֳ��ϸ� target�� �Ǵ� �޼ҵ带 ���� �����ؾ� ������ �츮�� ���ϴ� �ǵ� �װ� jp.proceed() �̸�
      // jointpoint�� �� �޼ҵ带 ������ ���� �ʰ�, ProceedingJoinPoint�� ������ �ִ�.
      
      //jp�� � ���� return ���� �𸣹Ƿ� object�� �������� �ۼ�.
      
      Object result = null;
       try {
          // @Before ���� �� ��ɵ� �ۼ�
          logger.info("=====�޼ҵ� ȣ�� ��");
          
          // target�� pointcut �޼ҵ带 ȣ��. 
          // Around �޼ҵ� �Ф��ؾ������ ���� �Ф�
          result = jp.proceed();
          
          // @AfterRetruning���� �� ��ɵ� �ۼ� (���������� return �޾��� ��)
          logger.info("=====�޼ҵ� ���� ��");          
              
          
          
       } catch(Throwable e) {          
          // @AfterThrowing���� �ؾ� �� ��� �ۼ�
          logger.info("=====�޼ҵ� ���� �� ���� �߻�");
                 
       } finally {          
          // @After���� �ؾ� �� ����� �ۼ�(������ �ϴ� �κ�)
          logger.info("=====finally ����");
       }        
       
      return result;
      // result = jp.proceed();�� ȣ������ ������
      // 1�� return ���� �ʰ�, null�� ���Ϲ޾� exception�� �߻��Ѵ�.
   }
   
   
   
}//end class SecurityAspect