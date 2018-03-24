package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements  UserService{
	private UserDao dao = new UserDaoImpl();
	
	public int QueryOne(String name, String pwd) {
		return dao.QueryOne(name, pwd);
	}
}
