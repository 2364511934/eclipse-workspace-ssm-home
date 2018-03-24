package test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author Administrator 这个Version1 是jdbc 连接程序的第一个版本
 * 仅仅实现语句查询功能
 */
public class Version1 {

	public static void main(String[] args) throws SQLException {
		// 1.借助于DriverManager实现驱动的注册(mysql驱动就在Drivermanager中管理)
		// 仅仅只有new Driver 使用 mysql 下的接口其他均使用java.sql 下的接口
		DriverManager.registerDriver(new Driver()); 
		
		// 2.建立连接
		// jdbc:mysql://localhost:3306/bd1711
		// 协议:子协议://ip:端口/数据库名字
		// 统一资源定位符(路径) 和mysql
		// DBMS的哪个数据库建立连接
		// http://www.baidu.com
		// 协议://ip:端口
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711",
				                                      "root",  // 用户名
				                                      "root"); // 密码
		
		//3.借助于Statement发送sql指令 此处也使用 java.sql 的接口
		String sql = "select * from emp";
	
		//创建Statement的实现类的对象
		Statement stmt = conn.createStatement();
		
		// 发送 sql 语句 返回结果集合
		ResultSet  rs = stmt.executeQuery(sql);
		// 5. 处理结果集
		while(rs.next()) {  // 遍历每一行数据 rs.next 类似游标
			//遍历每一列的数据
			// 0      1      2     3   4        5     6     7
			// empno  ename job   mgr  hiredate sal  comm deptno
			int empno = rs.getInt("empno"); 
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			int mgr = rs.getInt("mgr");
			Date hiredate = rs.getDate("hiredate");
			BigDecimal sal = rs.getBigDecimal("sal");
			BigDecimal comm = rs.getBigDecimal("comm");
			int deptno = rs.getInt("deptno");
			
			System.out.println("empno:"+empno
					            +"\tename:"+ename 
					            + "\tjob:"+job
					            +"\tmgr:"+mgr
					            +"\thiredata:" + hiredate 
					            + "\tsal:" +  sal
					            + "\tcomm:"+ comm
					            + "\tdeptno:" + deptno);
		}
		
		//5.释放资源
		rs.close();
		stmt.close();
		conn.close();
		

	}

}
