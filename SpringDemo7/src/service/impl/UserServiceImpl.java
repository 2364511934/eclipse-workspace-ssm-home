package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.UserDao;
import service.UserService;

@Component("userservice")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userdao")
	UserDao dao;
	
	@Override
	public void addUser() {
		dao.addUser();
	}

	@Override
	public void deleteUser() {
		dao.deleteUser();
	}

}
