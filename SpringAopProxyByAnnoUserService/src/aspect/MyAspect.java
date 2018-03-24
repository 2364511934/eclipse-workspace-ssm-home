package aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* service..*(..))")
	public void pointCut() {
		
	}
	
	@Before("pointCut()")
	public void before() {
		System.out.println("before");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("after");
	}
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("afterReturning");
	}
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("afterThrowing");
	}
	
	/*public void around(ProceedingJoinPoint jointPoint) {
		
		try {
			System.out.println("before");
			jointPoint.proceed();
			System.out.println("afterReturning");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("afterThrowing");
		}finally {
			System.out.println("after");
		}
	}*/
	
}
