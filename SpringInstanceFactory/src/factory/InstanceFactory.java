package factory;

import entity.User;

public class InstanceFactory {
	public  User createUser() {
		return new User();
	}
}
