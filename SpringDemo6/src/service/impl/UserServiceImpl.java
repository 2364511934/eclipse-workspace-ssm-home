package service.impl;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {

	UserDao dao = null;
	
	public void setDao(UserDao dao) {
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
