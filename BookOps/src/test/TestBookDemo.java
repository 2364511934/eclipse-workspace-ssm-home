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
	// ��ѯָ��һ��
	@Test
	public void selectBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		Book book = bookMapper.selectBookOne(3);
		System.out.println(book);
		MybatisUtils.closeSession();
	}
	
	
	// ��ѯ����
	@Test
	 public void selectBookAllTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		List<Book> books = bookMapper.selectBookAll();
		System.out.println(books);
		MybatisUtils.closeSession();
	}
	
	// ����һ��
	@Test
	public void insertBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		Book book = new Book(3, "Java�����ŵ���ͨ", "̷��ǿ", 34.8);
		int rows = bookMapper.insertBookOne(book);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}
	// �޸�һ��
	@Test
	public void updateBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper= session.getMapper(BookMapper.class);
		Book book = new Book(9, "J2ee�����ŵ���ͨ", "����", 33.5);
		int rows = bookMapper.updateBookOne(book);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}
	
	// ɾ��һ��
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
