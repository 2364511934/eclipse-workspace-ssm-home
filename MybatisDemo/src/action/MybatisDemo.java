package action;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Book;

public class MybatisDemo {

	public static void main(String[] args) {
		try {
			//加载配置文件为流
			InputStream is = Resources.getResourceAsStream("my.xml");
			//创建SqlSessionFactory(加载)
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			//核心接口（发送增删改查语句）
			SqlSession session = ssf.openSession();
			
			Book book = session.selectOne("com.lee.selectBook", 1);
			System.out.println(book);
			
			//释放资源
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
