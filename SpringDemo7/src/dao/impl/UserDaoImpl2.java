package dao.impl;

import org.springframework.stereotype.Component;

import dao.UserDao;

@Component("userdao2")
public class UserDaoImpl2 implements UserDao {

	@Override
	public void addUser() {
		System.out.println("增加用户");
	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户");
	}
	

}
