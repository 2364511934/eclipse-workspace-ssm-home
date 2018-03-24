package test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author yhj
 * 
 *         mysql> desc user
 *         +-----------+-------------+------+-----+---------+-------+ | Field |
 *         Type | Null | Key | Default | Extra |
 *         +-----------+-------------+------+-----+---------+-------+ | | uname
 *         | varchar(20) | NO | | NULL | | | upassword | varchar(20) | NO | |
 *         NULL | | +-----------+-------------+------+-----+---------+-------+ 3
 *         rows in set (0.01 sec)
 */
public class LoginDemoVersion3 {

	public static void main(String[] args) throws SQLException {
		// loginUnSafe("zs", "123");
		/**
		 * mysql> select * from user; +-------+-----------+ | uname | upassword |
		 * +-------+-----------+ | ls | 456 | | zs | 123 | +-------+-----------+ 2 rows
		 * in set (0.00 sec)
		 */
		// loginUnSafe("yyy' or 1=1 or '", "vvvv");
		// loginSafe("zs", "123");
		// loginSafe("yyy' or 1=1 or '", "vvvv");
		//InsertAndUpdateUnSafeBatch(new String[] { "wangwu", "zs" }, new String[] { "123456", "password" });
		InsertSafeBatch(new String[] { "zhaoliu", "qianqi" }, new String[] { "123456", "123456" });
	}

	// 不安全批量添加和修改
	public static int InsertAndUpdateUnSafeBatch(String[] uname, String[] upassword) throws SQLException {
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
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // 用户名
				"root"); // 密码

		// 3.借助于Statement发送sql指令 此处也使用 java.sql 的接口
		// 第一个用于插入一条语句
		String sql1 = "insert into user values('" + uname[0] + "', '" + upassword[0] + "')";
		// 第二条用于修改一条语句
		String sql2 = "update  user set upassword= '" + upassword[1] + "' where uname = '" + uname[1] + "'";
		// 创建Statement的实现类的对象
		Statement stmt = conn.createStatement();

		stmt.addBatch(sql1);
		stmt.addBatch(sql2);

		// 发送 sql 语句 返回结果集合
		int[] ret = stmt.executeBatch();

		// 5. 处理结果集 应该是返回二条结果集
		if (ret.length == 2) {
			System.out.println("执行成功");
		} else {
			System.out.println("执行失败");
		}

		// 5.释放资源
		stmt.close();
		conn.close();
		return 0;
	}

	// 安全批量添加和修改
	public static int InsertSafeBatch(String[] uname, String[] upassword) throws SQLException {
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
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // 用户名
				"root"); // 密码

		// 3.借助于Statement发送sql指令 此处也使用 java.sql 的接口
		// 第一个用于插入一条语句 批量添加 一次只能执行一种类型的语句
		String sql = "insert into user values(?, ?)";
		// 创建Statement的实现类的对象
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname[0]);
		ps.setString(2, upassword[0]);
		ps.addBatch();
		
		ps.setString(1, uname[1]);
		ps.setString(2, upassword[1]);
		ps.addBatch();
		
		// 发送 sql 语句 返回结果集合
		int[] ret = ps.executeBatch();

		// 5. 处理结果集 应该是返回二条结果集
		if (ret.length == 2) {
			System.out.println("执行成功");
		} else {
			System.out.println("执行失败");
		}

		// 5.释放资源
		ps.close();
		conn.close();
		return 0;
	}

	// 用户登录 非安全登录 可能遭遇SQL注入
	public static int loginUnSafe(String uname, String upassword) throws SQLException {
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
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // 用户名
				"root"); // 密码

		// 3.借助于Statement发送sql指令 此处也使用 java.sql 的接口
		String sql = "select * from user where uname='" + uname + "' and upassword = '" + upassword + "'";

		// 创建Statement的实现类的对象
		Statement stmt = conn.createStatement();

		// 发送 sql 语句 返回结果集合
		ResultSet rs = stmt.executeQuery(sql);
		// 5. 处理结果集
		if (rs.next()) {
			System.out.println("登录成功");
			do {
				String name = rs.getString("uname");
				String password = rs.getString("upassword");
				System.out.println("用户名:" + name + "\t密码:" + password);
			} while (rs.next());

		} else {
			System.out.println("登录失败");
		}

		// 5.释放资源
		rs.close();
		stmt.close();
		conn.close();
		return 0;
	}

	// 用户登录 安全登录
	public static int loginSafe(String uname, String upassword) throws SQLException {
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
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // 用户名
				"root"); // 密码

		// 3.发送sql, ?占位符
		String sql = "select * from user where uname = ? and  upassword = ? ";
		// 支持sql的预编译(语法检查,语义检查 ... 查询)
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname); // index从1开始 uname
		ps.setString(2, upassword); // index从1开始 upassword

		// 发送 sql 语句 返回结果集合 使用的是 ps.executeQuery(); 不带参数的方法
		ResultSet rs = ps.executeQuery();
		// 5. 处理结果集
		if (rs.next()) {
			System.out.println("登录成功");
			do {
				String name = rs.getString("uname");
				String password = rs.getString("upassword");
				System.out.println("用户名:" + name + "\t密码:" + password);
			} while (rs.next());

		} else {
			System.out.println("登录失败");
		}

		// 5.释放资源
		rs.close();
		ps.close();
		conn.close();
		return 0;
	}
}
