package service;

import org.springframework.stereotype.Service;

@Service("userserice")
public class UserServiceImpl implements UserService {

	public void addUser() {
		System.out.println("�����û�");
	}

	public void deleteUser() {
		System.out.println("ɾ���û�");
	}

}
