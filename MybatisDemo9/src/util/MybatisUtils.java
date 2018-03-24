package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory ssf = null;
	static {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("MyBatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ssf = new SqlSessionFactoryBuilder().build(is);
	}
	
	// ´ò¿ªsession
	public static  SqlSession getSqlSession() {
		return ssf.openSession(true);
	}
	
	// ¹Ø±Õsession
	public static void closeSqlSession(SqlSession session) {
		
		session.close();
	}
	
	
}
