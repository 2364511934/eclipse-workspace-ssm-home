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
			//���������ļ�Ϊ��
			InputStream is = Resources.getResourceAsStream("my.xml");
			//����SqlSessionFactory(����)
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			//���Ľӿڣ�������ɾ�Ĳ���䣩
			SqlSession session = ssf.openSession();
			
			Book book = session.selectOne("com.lee.selectBook", 1);
			System.out.println(book);
			
			//�ͷ���Դ
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
