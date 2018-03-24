package test;

import java.io.IOException;

import dao.BookDao;

public class TestMybatisDemo {
	public static void main(String[] args) throws IOException {
		BookDao bookDao = new BookDao();
		
		bookDao.selectBookAll();
		//bookDao.selectBookOne();
		
		//Book book = new Book("三国志", "陈寿", 34.7);
		
		//bookDao.insertBookOne(book);
		/*Book book = new Book("三国志", "陈寿", 34.7);
		book.setBid(2);
		bookDao.updateBookOne(book);*/
		
		/*bookDao.deleteBookOne(2);*/
		
	}
}
