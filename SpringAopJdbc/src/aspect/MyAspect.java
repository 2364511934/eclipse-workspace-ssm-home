package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myaspect")
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* service..*(..))")
	public void pointCut() {
		
	}
	
	//@Before("\"execution(* service..*(..))")
	@Before("pointCut()")
	public void before() {
		System.out.println("�������� :@Before(\"pointCut()\")");
		
	}
	
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("�ύ����:@AfterReturning(\"pointCut()\")");
	}
	
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("�׳��쳣:@AfterThrowing(\"pointCut()\")");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("����ִ��:@After(\"pointCut()\")");
	}
	
/*	public void around(ProceedingJoinPoint jointPoint) {
		try {
			System.out.println(jointPoint.getSignature().getName()); 
			System.out.println(jointPoint.getTarget()); 
			System.out.println("��������");
			jointPoint.proceed();
			System.out.println("�ύ����");
		} catch (Throwable e) {
			System.out.println("�׳��쳣");
			e.printStackTrace();
		}finally {
			System.out.println("����ִ��");
		}
		
	}*/
}
