package dao.impl;

import dao.UserDao;

public class ProxyUserDaoImpl implements UserDao {

	UserDao dao ;
	
	public  ProxyUserDaoImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public void addUser() {
		dao.addUser();
	}

	@Override
	public void deleteUser() {
		dao.deleteUser();
	}
	
}
