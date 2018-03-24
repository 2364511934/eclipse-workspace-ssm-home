package test;


import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


import dao.impl.UserDaoImpl;

public class Test {
	@org.junit.Test
	public void test() {
		UserDaoImpl dao = new UserDaoImpl();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserDaoImpl.class);
		
		Callback callback = new MethodInterceptor() {
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				
				System.out.println("��������");
				//method.invoke(dao, args);
				methodProxy.invokeSuper(proxy, args); // ���������һ����
				System.out.println("��������");
				
				return null;
			}
		};
		
		enhancer.setCallback(callback);
		UserDaoImpl proxy = (UserDaoImpl) enhancer.create();
		
		proxy.addUser();
		proxy.deleteUser();
	}
}
