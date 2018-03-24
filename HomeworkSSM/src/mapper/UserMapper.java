package mapper;

import java.util.List;

import entity.User;

public interface UserMapper {
	
	List<User> queryOne(User user);
}
