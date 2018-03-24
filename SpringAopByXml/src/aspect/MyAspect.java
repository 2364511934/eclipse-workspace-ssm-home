package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void before() {
		System.out.println("��������");
		
	}
	
	public void afterReturning() {
		System.out.println("�ύ����");
	}
	
	public void afterThrowing() {
		System.out.println("�׳��쳣");
	}
	
	public void after() {
		System.out.println("����ִ��");
	}
	
	public void around(ProceedingJoinPoint jointPoint) {
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
		
	}
}
