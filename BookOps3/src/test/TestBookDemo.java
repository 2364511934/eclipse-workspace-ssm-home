package test;

import java.util.ArrayList;
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
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		Book book = bookMapper.selectBookOne(3);
		System.out.println(book);
		MybatisUtils.closeSession();
	}

	// 查询所有
	@Test
	public void selectBookAllTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		List<Book> books = bookMapper.selectBookAll();
		System.out.println(books);
		MybatisUtils.closeSession();
	}

	// 增加一个
	@Test
	public void insertBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		Book book = new Book(3, "Java从入门到精通", "谭浩强", 34.8);
		int rows = bookMapper.insertBookOne(book);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}

	// 修改一个
	@Test
	public void updateBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		Book book = new Book(9, "J2ee从入门到精通", "梁勇", 33.5);
		int rows = bookMapper.updateBookOne(book);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}

	// 删除一个
	@Test
	public void deleteBookOneTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		int rows = bookMapper.deleteBookOne(11);
		System.out.println(rows);
		MybatisUtils.closeSession();
	}

	// 查询指定的几个
	@Test
	public void selectBookAll2Test() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		Book book = new Book(1, "三国演义", "梁勇", 33.5);
		List<Book> books = bookMapper.selectBookAll2(book);
		System.out.println(books);
		MybatisUtils.closeSession();
	}

	// 查询指定的几个
	@Test
	public void selectBookAll3Test() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		// Book book = new Book(-1, "西游记3", "罗贯中", 33.5);
		Book book = new Book(-1, null, "罗贯中", 33.5);
		// Book book = new Book(-1, "西游记3", "罗贯中", 33.5);
		List<Book> books = bookMapper.selectBookAll3(book);
		System.out.println(books);
		MybatisUtils.closeSession();
	}

	// 查询指定的 foreach
	@Test
	public void selectBookByForeach() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		List<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);

		List<Book> books = bookMapper.selectBookByForeach(lists);
		System.out.println(books);
		MybatisUtils.closeSession();
	}

	// 测试懒加载
	// 查询所有
	@Test
	public void selectBookAllLazyTest() {
		SqlSession session = MybatisUtils.getSession();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		List<Book> books = bookMapper.selectBookAll();
		System.out.println(books);
		books = bookMapper.selectBookAll();
		System.out.println(books);
		MybatisUtils.closeSession();
	}

	// 测试懒加载 测试二级缓存
	// 查询所有
	@Test
	public void selectBookAllLazy2Test() {
		SqlSession session = MybatisUtils.getSessionTemp();
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		List<Book> books = bookMapper.selectBookAll();
		System.out.println(books);
		MybatisUtils.closeSessionTemp(session);
		SqlSession session2 = MybatisUtils.getSessionTemp();
		BookMapper bookMapper2 = session2.getMapper(BookMapper.class);
		List<Book> books2 = bookMapper2.selectBookAll();
		System.out.println(books2);
		MybatisUtils.closeSessionTemp(session2);
		
		
	}

	@After
	public void BookTestAfter() {
		System.out.println("BookTestAfter");
	}
}
