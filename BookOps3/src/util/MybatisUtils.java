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
			// ��ȡ�����ļ�ת��Ϊ��
			InputStream is = Resources.getResourceAsStream("Mybatis.xml");
			// ����ssf����
			ssf = new SqlSessionFactoryBuilder().build(is);
			// �����̳߳ض���
			threadLocal = new ThreadLocal<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ��ȡsqlsession����
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();
		if (session == null) {
			// �����Զ��ύ
			session = ssf.openSession(true);
			threadLocal.set(session);
		}
		return session;
	}

	// �ر�session
	public static void closeSession() {
		SqlSession session = threadLocal.get();
		if (session != null) {
			session.close();
			threadLocal.remove();
		}
	}

	// ��ȡsqlsession���� ��ʱ����
	public static SqlSession getSessionTemp() {
		SqlSession session = ssf.openSession(true);
		threadLocal.set(session);
		return session;
	}

	// �ر�session ��ʱ����
	public static void closeSessionTemp(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}
