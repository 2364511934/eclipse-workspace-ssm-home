package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author Administrator SET FOREIGN_KEY_CHECKS=0;
 * 
 *         -- ---------------------------- -- Table structure for `user` --
 *         ---------------------------- DROP TABLE IF EXISTS `user`; CREATE
 *         TABLE `user` ( `uid` int(11) NOT NULL, `uname` varchar(20) NOT NULL,
 *         `upassword` varchar(20) NOT NULL, PRIMARY KEY (`uid`) ) ENGINE=InnoDB
 *         DEFAULT CHARSET=utf8;
 * 
 *         -- ---------------------------- -- Records of user --
 *         ---------------------------- INSERT INTO `user` VALUES ('1', 'zs',
 *         '123');
 * 
 *         mysql> desc classroom
 *         +-------+-------------+------+-----+---------+-------+ | Field | Type
 *         | Null | Key | Default | Extra |
 *         +-------+-------------+------+-----+---------+-------+ | cid |
 *         int(11) | NO | PRI | NULL | | | cname | varchar(20) | NO | | NULL | |
 *         +-------+-------------+------+-----+---------+-------+
 */

public class Version2 {

	public static void main(String[] args) throws Exception {
		// 添加一条记录
		// insert(4, "classroom4");

		// 修改一条记录
		// update(3, "croom3");
		
		// 删除一条记录
		delete(3);

	}

	// 添加 一条记录
	public static int insert(int cid, String cname) throws Exception {
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
		String sql = "insert into classroom values(" + cid + ",'" + cname + "')";

		// 创建Statement的实现类的对象
		Statement stmt = conn.createStatement();

		// 发送 sql 语句 返回执行几条记录
		int ret = stmt.executeUpdate(sql);
		// 此处返回值表示1成功 0 表示失败
		if (ret > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}

		// 5.释放资源
		stmt.close();
		conn.close();
		return ret;
	}

	// 修改一条记录
	public static int update(int cid, String cname) throws SQLException {
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
		String sql = "update classroom set cname = '" + cname + "' where cid = " + cid;

		// 创建Statement的实现类的对象
		Statement stmt = conn.createStatement();

		// 发送 sql 语句 返回执行几条记录
		int ret = stmt.executeUpdate(sql);
		// 此处返回值表示1成功 0 表示失败
		if (ret > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}

		// 5.释放资源
		stmt.close();
		conn.close();
		return ret;
	}

	// 删除一条记录
	public static int delete(int cid) throws SQLException {
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
		String sql = "delete from classroom where cid =" + cid;

		// 创建Statement的实现类的对象
		Statement stmt = conn.createStatement();

		// 发送 sql 语句 返回执行几条记录
		int ret = stmt.executeUpdate(sql);
		// 此处返回值表示1成功 0 表示失败
		if (ret > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}

		// 5.释放资源
		stmt.close();
		conn.close();
		
		return ret;
	}
}
