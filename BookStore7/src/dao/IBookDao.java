package dao;

import java.util.List;

import bean.Book;

public interface IBookDao {
	
	List<Book> executeQueryAll();
		
}
