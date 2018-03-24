package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

public class BaseDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;

	// 通用查询
	public int executeUpdate(String sql, Object[] param) {
		int rows = 0;

		try {
			// 获取连接
			conn = JdbcUtils.getConnecton();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i + 1, param[i]);
			}

			rows = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(rs, ps, conn);
		}
		

		return rows;
	}

	// 通用增，删，改
	public <E> List<E> executeQuery(String sql, Object[] param, Class<E> clz) {
		List<E> lists = new ArrayList<>();
		int rows = 0;

		try {
			// 获取连接
			conn = JdbcUtils.getConnecton();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i + 1, param[i]);
			}

			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			
			while(rs.next()) {
				E e = clz.newInstance();
				for(int i =0; i<count; i++) {
					String name = rm.getColumnName(i+1);
					Object value = rs.getObject(name);
					Field f = clz.getDeclaredField(name);
					f.setAccessible(true);
					f.set(e, value);
				}
				lists.add(e);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			JdbcUtils.closeRes(rs, ps, conn);
		}
		
		return lists;
	}
}
