package dao;

import java.util.List;

import bean.Book;

public interface BookDao{
	public List<Book> executeQueryAll();
}
