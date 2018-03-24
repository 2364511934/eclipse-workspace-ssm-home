package test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserServiceImpl;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ApplicationContext.xml")

public class Test {
	@Autowired
	UserServiceImpl service;
	@org.junit.Test
	public void testAopProxyByXmlUserService() {
		service.addUser();
	}
}
