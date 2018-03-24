package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;

public class Test {
	@org.junit.Test
	public void test() {
		ApplicationContext as = new ClassPathXmlApplicationContext("ApplicationContextxml.xml");
		UserDao userDao = as.getBean("userdao", UserDao.class);
		userDao.addUser();
		userDao.deleteUser();
	}
}
