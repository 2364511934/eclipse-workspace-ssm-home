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
 * @author Administrator ���Version1 ��jdbc ���ӳ���ĵ�һ���汾
 * ����ʵ������ѯ����
 */
public class Version1 {

	public static void main(String[] args) throws SQLException {
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
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1711",
				                                      "root",  // �û���
				                                      "root"); // ����
		
		//3.������Statement����sqlָ�� �˴�Ҳʹ�� java.sql �Ľӿ�
		String sql = "select * from emp";
	
		//����Statement��ʵ����Ķ���
		Statement stmt = conn.createStatement();
		
		// ���� sql ��� ���ؽ������
		ResultSet  rs = stmt.executeQuery(sql);
		// 5. ��������
		while(rs.next()) {  // ����ÿһ������ rs.next �����α�
			//����ÿһ�е�����
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
		
		//5.�ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
		

	}

}
