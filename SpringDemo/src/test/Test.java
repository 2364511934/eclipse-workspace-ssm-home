package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import service.UserService;

public class Test {
	@org.junit.Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		UserDao userDao = ac.getBean("userdao", UserDao.class);
		userDao.addUser();
		userDao.deleteUser();
	}
	
	@org.junit.Test
	public void testService() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		UserService userService = ac.getBean("userservice", UserService.class);
		userService.addUser();
		userService.deleteUser();
	}
}
