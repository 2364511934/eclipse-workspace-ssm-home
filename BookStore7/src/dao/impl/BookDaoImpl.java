package dao.impl;

import java.util.List;

import bean.Book;
import dao.BaseDao;
import dao.IBookDao;


public class BookDaoImpl extends BaseDao implements IBookDao {
	
	public List<Book> executeQueryAll(){
		String sql = "select * from book";
		Object[] params = {}; 
		
		return executeQuery(sql, params, Book.class);
	}
}