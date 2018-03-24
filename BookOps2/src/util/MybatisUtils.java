package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

	private static SqlSessionFactory ssf = null;
	private static ThreadLocal<SqlSession> threadLocal = null;
	static {
		try {
			// 读取配置文件转换为流
			InputStream is = Resources.getResourceAsStream("Mybatis.xml");
			// 创建ssf对象
			ssf = new SqlSessionFactoryBuilder().build(is);
			// 创建线程池对象
			threadLocal = new ThreadLocal<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取sqlsession对象
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();
		if (session == null) {
			// 开启自动提交
			session = ssf.openSession(true);
			threadLocal.set(session);
		}
		return session;
	}

	// 关闭session
	public static void closeSession() {
		SqlSession session = threadLocal.get();
		if (session != null) {
			session.close();
			threadLocal.remove();
		}
	}

	// 获取sqlsession对象 临时方法
	public static SqlSession getSessionTemp() {
		SqlSession session = ssf.openSession(true);
		threadLocal.set(session);
		return session;
	}

	// 关闭session 临时方法
	public static void closeSessionTemp(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}
