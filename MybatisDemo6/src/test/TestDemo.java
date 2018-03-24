package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import entity.Role;
import mapper.RoleMapper;
import util.MybatisUtils;

public class TestDemo {
	/*public static void main(String[] args) {
		SqlSession session = MybatisUtils.getSqlSession();

		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		List<Role> roles = roleMapper.queryAll();

		System.out.println(roles);

		MybatisUtils.closeSqlSession(session);
	}*/
	
	@Test
	public void testRole() {
		SqlSession session = MybatisUtils.getSqlSession();

		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		List<Role> roles = roleMapper.queryAll();

		System.out.println(roles);

		MybatisUtils.closeSqlSession(session);
	}

}
