package Dao;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

public class BaseDao {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	// 执行 插入、更改、删除
	public int executeUpdate(String sql, Object[] param) throws Exception {
		int rows = 0;
		
		try {
			conn = JdbcUtils.getConnecton();
			ps = conn.prepareStatement(sql);
			for(int i =0; i<param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			
			rows = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtils.closeRes(rs, ps, conn);
		}
		
		
		return rows;
	}
	
	
	// 查询
	public <T> List<T> executeQuery(String sql, Object[] param, Class<?> c) throws Exception {
		conn = JdbcUtils.getConnecton();
		ps = conn.prepareStatement(sql);
		for(int i =0; i<param.length; i++) {
			ps.setObject(i+1, param[i]);
		}
		
		rs = ps.executeQuery();
		//元数据:解释数据的数据
		ResultSetMetaData md = rs.getMetaData();
		// 查询的字段的总数
		int count = md.getColumnCount();
		List<T> lists = new ArrayList<>();
		while(rs.next()) { //遍历一行就需要创建一个对象进行封装
			//创建t对象  (调用t的class对象创建t对象,调用无参构造创建对象) 
			T t = (T) c.newInstance();
			for(int i = 0; i<count; i++) {
				//获取每个字段的值(遍历获取每行中每个字段的值)
				Object o = rs.getObject(i+1);
				//先获取字段名称
				String name = md.getColumnName(i+1);
				//根据字段名称获取相应的属性,将字段的值赋给属性
				Field f = c.getDeclaredField(name);
				//设置允许赋值
				f.setAccessible(true);
				if(null != o) {
					f.set(t, o);
				}
			}
			lists.add(t);
		}
	
		return lists;
	}
	
}
