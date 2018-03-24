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
	
	// ִ�� ���롢���ġ�ɾ��
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
	
	
	// ��ѯ
	public <T> List<T> executeQuery(String sql, Object[] param, Class<?> c) throws Exception {
		conn = JdbcUtils.getConnecton();
		ps = conn.prepareStatement(sql);
		for(int i =0; i<param.length; i++) {
			ps.setObject(i+1, param[i]);
		}
		
		rs = ps.executeQuery();
		//Ԫ����:�������ݵ�����
		ResultSetMetaData md = rs.getMetaData();
		// ��ѯ���ֶε�����
		int count = md.getColumnCount();
		List<T> lists = new ArrayList<>();
		while(rs.next()) { //����һ�о���Ҫ����һ��������з�װ
			//����t����  (����t��class���󴴽�t����,�����޲ι��촴������) 
			T t = (T) c.newInstance();
			for(int i = 0; i<count; i++) {
				//��ȡÿ���ֶε�ֵ(������ȡÿ����ÿ���ֶε�ֵ)
				Object o = rs.getObject(i+1);
				//�Ȼ�ȡ�ֶ�����
				String name = md.getColumnName(i+1);
				//�����ֶ����ƻ�ȡ��Ӧ������,���ֶε�ֵ��������
				Field f = c.getDeclaredField(name);
				//��������ֵ
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
