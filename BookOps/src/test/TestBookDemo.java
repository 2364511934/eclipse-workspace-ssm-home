package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Book;
import mapper.BookMapper;
import util.MybatisUtils;

public class TestBookDemo {
	
	@Before
	public void BookTestBefore() {
		System.out.println("BookTestBefore");
	}
	// 查询指定一个
	@Test
	public void selectBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		Book book = bookMapper.selectBookOne(3);
		System.out.println(book);
		MybatisUtils.closeSession();
	}
	
	
	// 查询所有
	@Test
	 public void selectBookAllTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		List<Book> books = bookMapper.selectBookAll();
		System.out.println(books);
		MybatisUtils.closeSession();
	}
	
	// 增加一个
	@Test
	public void insertBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		Book book = new Book(3, "Java从入门到精通", "谭浩强", 34.8);
		int rows = bookMapper.insertBookOne(book);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}
	// 修改一个
	@Test
	public void updateBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		Book book = new Book(9, "J2ee从入门到精通", "梁勇", 33.5);
		int rows = bookMapper.updateBookOne(book);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}
	
	// 删除一个
	@Test
	public void deleteBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		int rows = bookMapper.deleteBookOne(11);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}
	
	@After
	public void BookTestAfter() {
		System.out.println("BookTestAfter");
	}
}
