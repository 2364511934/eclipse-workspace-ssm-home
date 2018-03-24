package dao;

import java.util.List;

import bean.Book;

public class BookDao extends BaseDao {
	
	public List<Book> executeQueryAll(){
		String sql = "select * from book";
		Object[] params = {}; 
		
		return executeQuery(sql, params, Book.class);
	}
}
