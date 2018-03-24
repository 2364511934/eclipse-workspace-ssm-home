package dao.impl;

import java.util.List;

import bean.Book;
import dao.BaseDao;
import dao.BookDao;


public class BookDaoImpl extends BaseDao implements BookDao  {
	
	public List<Book> executeQueryAll(){
		String sql = "select * from book";
		Object[] params = {}; 
		
		return executeQuery(sql, params, Book.class);
	}
}