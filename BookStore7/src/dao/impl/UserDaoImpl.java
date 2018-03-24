package dao.impl;

import java.util.List;

import bean.User;
import dao.BaseDao;
import dao.IUserDao;

public class UserDaoImpl extends BaseDao implements IUserDao {
	
	public int QueryOne(String name, String pwd) {
		String sql = "select * from `user` where uname = ? and pwd = ?";
		Object[] params= {name, pwd};
		List<User> lists =  executeQuery(sql, params, User.class) ;
		if(lists.isEmpty()) {
			return 0;
		}
		return 1;
	}
}