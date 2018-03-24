package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import entity.User;

public class Test {
	@org.junit.Test
	public void test() {
		ApplicationContext as = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		UserDao userDao = as.getBean("userdao", UserDao.class);
		userDao.addUser();
		userDao.deleteUser();
	}
	
	@org.junit.Test
	public void testUser() {
		ApplicationContext as = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		User user = as.getBean("usersetmethod", User.class);
		System.out.println(user.toString());
		
	}
	
	// 测试有参数构造
	@org.junit.Test
	public void testConstructorUser() {
		ApplicationContext as = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		User user = as.getBean("userconstructor", User.class);
		System.out.println(user.toString());
		
	}
	
	// 测试有参数构造
		@org.junit.Test
		public void testConstructorUser2() {
			ApplicationContext as = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
			User user = as.getBean("userconstructor2", User.class);
			System.out.println(user.toString());
			
		}
}
