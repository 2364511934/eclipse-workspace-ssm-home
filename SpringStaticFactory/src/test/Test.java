package test;

import java.lang.reflect.InvocationTargetException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.User;

public class Test {
	@org.junit.Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		User user= ac.getBean("user", User.class);
		System.out.println(user);
		User user2= ac.getBean("user", User.class);
		System.out.println(user2);
		ac.getClass().getMethod("close").invoke(ac);
	}
	
	@org.junit.Test
	public void testStaticFactory() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		User user= ac.getBean("createuser", User.class);
		System.out.println(user);
		//ac.getClass().getMethod("close").invoke(ac);
	}
}
