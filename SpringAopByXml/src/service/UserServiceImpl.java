package service;

import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService {

	public void addUser() {
		System.out.println("增加用户");
	}

	public void deleteUser() {
		System.out.println("删除用户");
	}

}
