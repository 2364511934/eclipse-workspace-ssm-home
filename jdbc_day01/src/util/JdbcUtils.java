package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

	static String url = null;
	static String user = null;
	static String pwd = null;
	
	static{
		// 1.ע������
		//����properties����
		try {
			Properties properties =new Properties();
			//��propertes�ļ�����Ϊ��
			InputStream is = JdbcUtils.class
								.getClassLoader()
								.getResourceAsStream("jdbc.properties");
			//����
			properties.load(is);
			//ͨ��keyֵ��ȡvalueֵ
			String driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			pwd = properties.getProperty("pwd");
			// 1.ע������
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnecton() throws Exception{
		return DriverManager.getConnection(url,user,pwd);
	}
	
	public static void closeRes(ResultSet rs,Statement ps,Connection conn){
		//5.�ͷ���Դ
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
