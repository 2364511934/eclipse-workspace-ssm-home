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
		// ���һ����¼
		// insert(4, "classroom4");

		// �޸�һ����¼
		// update(3, "croom3");
		
		// ɾ��һ����¼
		delete(3);

	}

	// ��� һ����¼
	public static int insert(int cid, String cname) throws Exception {
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
		String sql = "insert into classroom values(" + cid + ",'" + cname + "')";

		// ����Statement��ʵ����Ķ���
		Statement stmt = conn.createStatement();

		// ���� sql ��� ����ִ�м�����¼
		int ret = stmt.executeUpdate(sql);
		// �˴�����ֵ��ʾ1�ɹ� 0 ��ʾʧ��
		if (ret > 0) {
			System.out.println("����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}

		// 5.�ͷ���Դ
		stmt.close();
		conn.close();
		return ret;
	}

	// �޸�һ����¼
	public static int update(int cid, String cname) throws SQLException {
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
		String sql = "update classroom set cname = '" + cname + "' where cid = " + cid;

		// ����Statement��ʵ����Ķ���
		Statement stmt = conn.createStatement();

		// ���� sql ��� ����ִ�м�����¼
		int ret = stmt.executeUpdate(sql);
		// �˴�����ֵ��ʾ1�ɹ� 0 ��ʾʧ��
		if (ret > 0) {
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}

		// 5.�ͷ���Դ
		stmt.close();
		conn.close();
		return ret;
	}

	// ɾ��һ����¼
	public static int delete(int cid) throws SQLException {
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
		String sql = "delete from classroom where cid =" + cid;

		// ����Statement��ʵ����Ķ���
		Statement stmt = conn.createStatement();

		// ���� sql ��� ����ִ�м�����¼
		int ret = stmt.executeUpdate(sql);
		// �˴�����ֵ��ʾ1�ɹ� 0 ��ʾʧ��
		if (ret > 0) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}

		// 5.�ͷ���Դ
		stmt.close();
		conn.close();
		
		return ret;
	}
}
