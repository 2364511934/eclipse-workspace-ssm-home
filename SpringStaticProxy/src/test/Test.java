package test;

import dao.UserDao;
import dao.impl.ProxyUserDaoImpl;
import dao.impl.UserDaoImpl2;

public class Test {
	@org.junit.Test
	public void test() {
		UserDao dao = new ProxyUserDaoImpl(new UserDaoImpl2());
		dao.addUser();
		dao.deleteUser();
	}
}
