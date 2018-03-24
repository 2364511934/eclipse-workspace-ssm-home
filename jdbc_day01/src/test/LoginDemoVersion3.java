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

	// ����ȫ������Ӻ��޸�
	public static int InsertAndUpdateUnSafeBatch(String[] uname, String[] upassword) throws SQLException {
		// 1.������DriverManagerʵ��������ע��(mysql��������Drivermanager�й���)
		// ����ֻ��new Driver ʹ�� mysql �µĽӿ�������ʹ��java.sql �µĽӿ�
		DriverManager.registerDriver(new Driver());

		// 2.��������
		// jdbc:mysql://localhost:3306/bd1711
		// Э��:��Э��://ip:�˿�/���ݿ�����
		// ͳһ��Դ��λ��(·��) ��mysql
		// DBMS���ĸ����ݿ⽨������
		// http://www.baidu.com
		// Э��://ip:�˿�
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // �û���
				"root"); // ����

		// 3.������Statement����sqlָ�� �˴�Ҳʹ�� java.sql �Ľӿ�
		// ��һ�����ڲ���һ�����
		String sql1 = "insert into user values('" + uname[0] + "', '" + upassword[0] + "')";
		// �ڶ��������޸�һ�����
		String sql2 = "update  user set upassword= '" + upassword[1] + "' where uname = '" + uname[1] + "'";
		// ����Statement��ʵ����Ķ���
		Statement stmt = conn.createStatement();

		stmt.addBatch(sql1);
		stmt.addBatch(sql2);

		// ���� sql ��� ���ؽ������
		int[] ret = stmt.executeBatch();

		// 5. �������� Ӧ���Ƿ��ض��������
		if (ret.length == 2) {
			System.out.println("ִ�гɹ�");
		} else {
			System.out.println("ִ��ʧ��");
		}

		// 5.�ͷ���Դ
		stmt.close();
		conn.close();
		return 0;
	}

	// ��ȫ������Ӻ��޸�
	public static int InsertSafeBatch(String[] uname, String[] upassword) throws SQLException {
		// 1.������DriverManagerʵ��������ע��(mysql��������Drivermanager�й���)
		// ����ֻ��new Driver ʹ�� mysql �µĽӿ�������ʹ��java.sql �µĽӿ�
		DriverManager.registerDriver(new Driver());

		// 2.��������
		// jdbc:mysql://localhost:3306/bd1711
		// Э��:��Э��://ip:�˿�/���ݿ�����
		// ͳһ��Դ��λ��(·��) ��mysql
		// DBMS���ĸ����ݿ⽨������
		// http://www.baidu.com
		// Э��://ip:�˿�
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // �û���
				"root"); // ����

		// 3.������Statement����sqlָ�� �˴�Ҳʹ�� java.sql �Ľӿ�
		// ��һ�����ڲ���һ����� ������� һ��ֻ��ִ��һ�����͵����
		String sql = "insert into user values(?, ?)";
		// ����Statement��ʵ����Ķ���
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname[0]);
		ps.setString(2, upassword[0]);
		ps.addBatch();
		
		ps.setString(1, uname[1]);
		ps.setString(2, upassword[1]);
		ps.addBatch();
		
		// ���� sql ��� ���ؽ������
		int[] ret = ps.executeBatch();

		// 5. �������� Ӧ���Ƿ��ض��������
		if (ret.length == 2) {
			System.out.println("ִ�гɹ�");
		} else {
			System.out.println("ִ��ʧ��");
		}

		// 5.�ͷ���Դ
		ps.close();
		conn.close();
		return 0;
	}

	// �û���¼ �ǰ�ȫ��¼ ��������SQLע��
	public static int loginUnSafe(String uname, String upassword) throws SQLException {
		// 1.������DriverManagerʵ��������ע��(mysql��������Drivermanager�й���)
		// ����ֻ��new Driver ʹ�� mysql �µĽӿ�������ʹ��java.sql �µĽӿ�
		DriverManager.registerDriver(new Driver());

		// 2.��������
		// jdbc:mysql://localhost:3306/bd1711
		// Э��:��Э��://ip:�˿�/���ݿ�����
		// ͳһ��Դ��λ��(·��) ��mysql
		// DBMS���ĸ����ݿ⽨������
		// http://www.baidu.com
		// Э��://ip:�˿�
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // �û���
				"root"); // ����

		// 3.������Statement����sqlָ�� �˴�Ҳʹ�� java.sql �Ľӿ�
		String sql = "select * from user where uname='" + uname + "' and upassword = '" + upassword + "'";

		// ����Statement��ʵ����Ķ���
		Statement stmt = conn.createStatement();

		// ���� sql ��� ���ؽ������
		ResultSet rs = stmt.executeQuery(sql);
		// 5. ��������
		if (rs.next()) {
			System.out.println("��¼�ɹ�");
			do {
				String name = rs.getString("uname");
				String password = rs.getString("upassword");
				System.out.println("�û���:" + name + "\t����:" + password);
			} while (rs.next());

		} else {
			System.out.println("��¼ʧ��");
		}

		// 5.�ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
		return 0;
	}

	// �û���¼ ��ȫ��¼
	public static int loginSafe(String uname, String upassword) throws SQLException {
		// 1.������DriverManagerʵ��������ע��(mysql��������Drivermanager�й���)
		// ����ֻ��new Driver ʹ�� mysql �µĽӿ�������ʹ��java.sql �µĽӿ�
		DriverManager.registerDriver(new Driver());

		// 2.��������
		// jdbc:mysql://localhost:3306/bd1711
		// Э��:��Э��://ip:�˿�/���ݿ�����
		// ͳһ��Դ��λ��(·��) ��mysql
		// DBMS���ĸ����ݿ⽨������
		// http://www.baidu.com
		// Э��://ip:�˿�
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711", "root", // �û���
				"root"); // ����

		// 3.����sql, ?ռλ��
		String sql = "select * from user where uname = ? and  upassword = ? ";
		// ֧��sql��Ԥ����(�﷨���,������ ... ��ѯ)
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname); // index��1��ʼ uname
		ps.setString(2, upassword); // index��1��ʼ upassword

		// ���� sql ��� ���ؽ������ ʹ�õ��� ps.executeQuery(); ���������ķ���
		ResultSet rs = ps.executeQuery();
		// 5. ��������
		if (rs.next()) {
			System.out.println("��¼�ɹ�");
			do {
				String name = rs.getString("uname");
				String password = rs.getString("upassword");
				System.out.println("�û���:" + name + "\t����:" + password);
			} while (rs.next());

		} else {
			System.out.println("��¼ʧ��");
		}

		// 5.�ͷ���Դ
		rs.close();
		ps.close();
		conn.close();
		return 0;
	}
}
