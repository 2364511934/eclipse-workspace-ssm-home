package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.BookMapper;

public class TestMybatis {
	@org.junit.Test
	public void Test() throws IOException {
		// 1.���������ļ�
		InputStream is = Resources.getResourceAsStream("Mybatis.xml");
		// 2.����ssf
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		// 3.ssf����session
		SqlSession session = ssf.openSession(true);
		// 4.��ȡmapperʵ����Ķ���
		BookMapper mapper = session.getMapper(BookMapper.class);
		// 5.����mapper�ķ���
		System.out.println(mapper.queryAll());
		// 6.�ر�session
		session.close();
	}
}
