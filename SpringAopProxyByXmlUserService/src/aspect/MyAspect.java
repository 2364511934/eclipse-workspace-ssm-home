package aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void before() {
		System.out.println("before");
	}
	
	public void after() {
		System.out.println("after");
	}
	
	public void afterReturning() {
		System.out.println("afterReturning");
	}
	
	public void afterThrowing() {
		System.out.println("afterThrowing");
	}
	
	public void around(ProceedingJoinPoint jointPoint) {
		
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
	}
	
}
