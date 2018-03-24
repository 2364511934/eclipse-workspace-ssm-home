package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UserService;

public class Test {
	@org.junit.Test
	public void testUserService() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserService userService= ac.getBean("userservice", UserService.class);
		userService.addUser();
		userService.deleteUser();
	}
}
