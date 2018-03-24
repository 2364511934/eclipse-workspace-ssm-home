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
		System.out.println("开启事务 :@Before(\"pointCut()\")");
		
	}
	
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("提交事务:@AfterReturning(\"pointCut()\")");
	}
	
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("抛出异常:@AfterThrowing(\"pointCut()\")");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("最终执行:@After(\"pointCut()\")");
	}
	
/*	public void around(ProceedingJoinPoint jointPoint) {
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
		
	}*/
}
