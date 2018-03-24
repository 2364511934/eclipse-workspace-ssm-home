package Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Emp;
import util.JdbcUtils;

public class EmpDao  extends BaseDao{

	//查询所有
	public List<Emp> queryAll() throws Exception{
		String sql = "select * from emp";
		Object[] params = {};
		return executeQuery(sql, params, Emp.class);
	}
	
	//增加
	public int insert(Emp emp) throws Exception{
		String sql = "insert into emp(empno,ename,deptno) values(?,?,?)";
		Object[] params = { emp.getEmpno(),emp.getEname(),emp.getDeptno() };
		return executeUpdate(sql, params);
	}
	
	public int delete(int empno) throws Exception{
		String sql = "delete from emp where empno=? ";
		Object[] params = { empno };
		return executeUpdate(sql, params);
	}
	
	public static void main(String[] args) throws Exception {
		EmpDao dao = new EmpDao();
		System.out.println(dao.queryAll());
	}
}
