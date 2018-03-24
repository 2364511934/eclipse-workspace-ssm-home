package service;

import java.util.List;

import bean.Book;

public interface IBookService {
	List<Book> executeQueryAll();
}
