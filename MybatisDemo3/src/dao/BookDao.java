package dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.Book;
import util.MybatisUtils;

public class BookDao {
	public void selectBookAll() throws IOException {
		SqlSession session = MybatisUtils.getSession();
		List<entity.Book> lists = session.selectList("mapper.BookMapper.selectBookAll");
		for(entity.Book book : lists) {
			System.out.println("book:"+book);
		}
		
		MybatisUtils.closeSession();
	}
	
	// 查询一个
	public void selectBookOne() throws IOException {
		SqlSession session = MybatisUtils.getSession();
		Book book = session.selectOne("mapper.BookMapper.selectBook", 1);
		System.out.println("book:"+book);
		MybatisUtils.closeSession();

	}
	
	// 插入一条数据
	public void insertBookOne(Book book) throws IOException {
		SqlSession session = MybatisUtils.getSession();
		int ret  = session.insert("mapper.BookMapper.insertBook", book);
		session.commit();
		System.out.println("book:"+book);
		MybatisUtils.closeSession();
	}
	
	// 修改一条数据
	public void updateBookOne(Book book) throws IOException {
		SqlSession session = MybatisUtils.getSession();
		int ret  = session.update("mapper.BookMapper.updateBook", book);
		session.commit();
		System.out.println("book:"+book);
		MybatisUtils.closeSession();
	}
	
	
	// 删除一本书
	public void deleteBookOne(int bid) throws IOException {
		SqlSession session = MybatisUtils.getSession();
		int ret  = session.update("mapper.BookMapper.deleteBook", bid);
		session.commit();
		System.out.println("book:"+bid);
		MybatisUtils.closeSession();
	}
}
