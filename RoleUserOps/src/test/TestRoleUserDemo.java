package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.User;
import mapper.UserMapper;
import util.MybatisUtils;

public class TestRoleUserDemo {
	
	@Before
	public void UserByRoleBefore() {
		System.out.println("UserByRoleBefore");
	}
	
	//查询用户信息
	@Test
	public void selectUserByRoleTest() {
		SqlSession session = MybatisUtils.getSession();
		UserMapper userMapper= session.getMapper(UserMapper.class);
		List<User> users = userMapper.selectUserAll();
		System.out.println(users);
		MybatisUtils.closeSession();
		
	}
	
	@After
	public void UserByRoleAfter() {
		System.out.println("UserByRoleAfter");
	}
}
