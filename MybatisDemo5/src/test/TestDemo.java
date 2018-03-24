package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.Book;
import mapper.BookMapper;
import util.MybatisUtils;

public class TestDemo {

	public static void main(String[] args) {
		SqlSession  session = MybatisUtils.getSqlSession();
		
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		List<Book> books = bookMapper.QueryAll();
		
		System.out.println(books);
		
		MybatisUtils.closeSqlSession(session);
	}

}
