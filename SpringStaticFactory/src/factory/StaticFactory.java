package factory;

import entity.User;

public class StaticFactory {
	public static User createUser() {
		return new User();
	}
}
