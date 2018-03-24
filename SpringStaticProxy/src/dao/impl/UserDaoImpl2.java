package dao.impl;

import dao.UserDao;

public class UserDaoImpl2 implements UserDao {

	@Override
	public void addUser() {
		System.out.println("增加用户2");
	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户2");
	}
	

}
