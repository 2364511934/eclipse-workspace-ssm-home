package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.JdbcUtils;

public class BaseDao {
	private  ResultSet rs = null;
	private  PreparedStatement ps = null;
	private  Connection conn = null;
	
	// 通用的增加、删除、修改
	public  int executeUpdate(String sql, Object[] param) {
		int rows = 0;
		try {
			conn = JdbcUtils.getConnecton();
			ps = conn.prepareStatement(sql);
			for(int i = 0; null !=param && i< param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeRes(rs, ps, conn);
		}
		
		return rows;
	}
	
	public  <T> List<T> executeQuery(String sql, Object[] param, Class<?> c) throws Exception{
		List<T> lists = null;;
		try {
			conn = JdbcUtils.getConnecton();
			ps = conn.prepareStatement(sql);
			for(int i = 0; null != param && i<param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();
			int count = md.getColumnCount();
			lists = new ArrayList<>();
			while(rs.next()) {
				T t = (T) c.newInstance();
				for(int i =0; i<count; i++) {
					// 获取值
					Object o = rs.getObject(i+1);
					String name = md.getColumnName(i+1);
					Field f = c.getDeclaredField(name);
					f.setAccessible(true);
					if(o != null) {
						f.set(t, o );
					}
				}
				lists.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeRes(rs, ps, conn);
		}
		
		return lists;
	}
}
