package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class Test {
	@org.junit.Test
	public void test() {
		UserDao dao = new UserDaoImpl();
		UserDao proxy = (UserDao)Proxy.newProxyInstance
				(dao.getClass().getClassLoader(), 
				 dao.getClass().getInterfaces(),
				 new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//System.out.println(method.getName());
						Object obj = null;
						if(method.getName().equals("addUser")) {
							System.out.println("开启事务");
							obj = method.invoke(dao, args);
							System.out.println("结束事务");
						}
						else {
							obj = method.invoke(dao, args);
						}
						
						return obj;
					}
				});
		proxy.addUser();
		proxy.deleteUser();
	}
}
