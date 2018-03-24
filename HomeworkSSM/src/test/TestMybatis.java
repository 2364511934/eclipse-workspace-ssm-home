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
		// 1.加载配置文件
		InputStream is = Resources.getResourceAsStream("Mybatis.xml");
		// 2.创建ssf
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		// 3.ssf创建session
		SqlSession session = ssf.openSession(true);
		// 4.获取mapper实现类的对象
		BookMapper mapper = session.getMapper(BookMapper.class);
		// 5.调用mapper的方法
		System.out.println(mapper.queryAll());
		// 6.关闭session
		session.close();
	}
}
