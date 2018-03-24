package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void before() {
		System.out.println("开启事务");
		
	}
	
	public void afterReturning() {
		System.out.println("提交事务");
	}
	
	public void afterThrowing() {
		System.out.println("抛出异常");
	}
	
	public void after() {
		System.out.println("最终执行");
	}
	
	public void around(ProceedingJoinPoint jointPoint) {
		try {
			System.out.println(jointPoint.getSignature().getName()); 
			System.out.println(jointPoint.getTarget()); 
			System.out.println("开启事务");
			jointPoint.proceed();
			System.out.println("提交事务");
		} catch (Throwable e) {
			System.out.println("抛出异常");
			e.printStackTrace();
		}finally {
			System.out.println("最终执行");
		}
		
	}
}
