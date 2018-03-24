package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import service.UserService;

public class Test {
	@org.junit.Test
	public void test() {
		ApplicationContext as = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		UserService userService = as.getBean("userservice", UserService.class);
		userService.addUser();
		userService.deleteUser();
	}
}
