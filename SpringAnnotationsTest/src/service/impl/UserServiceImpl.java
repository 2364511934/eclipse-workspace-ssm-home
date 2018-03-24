package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import dao.UserDao;
import service.UserService;

@Component("userservice")
public class UserServiceImpl implements UserService {

	@Resource(name="userdao")
	UserDao dao = null;
	
	@Override
	public void addUser() {
		dao.addUser();
	}

	@Override
	public void deleteUser() {
		dao.deleteUser();
	}
	
}
