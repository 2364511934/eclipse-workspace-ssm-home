package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtils {
	static String url = null;
	static String user = null;
	static String pwd = null;
	static String driver = null;
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		driver = rb.getString("driver");
		user = rb.getString("user");
		pwd = rb.getString("pwd");
		url = rb.getString("url");
	}
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnecton() throws Exception{
		return DriverManager.getConnection(url,user,pwd);
	}
	
	public static void closeRes(ResultSet rs,Statement ps,Connection conn){
		//5.ÊÍ·Å×ÊÔ´
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
