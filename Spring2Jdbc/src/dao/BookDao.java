package dao;

import java.util.List;

import entity.Book;

public interface BookDao {
	List<Book> queryAll();
}
