package service.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();
	@Override
	public int QueryOne(String name, String pwd) {
		return userDao.QueryOne(name, pwd);
	}

}
