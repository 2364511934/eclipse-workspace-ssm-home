package service.impl;

import java.util.List;

import bean.Book;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

public class BookServiceImpl  implements BookService{

	private BookDao dao = new BookDaoImpl();
	@Override
	public List<Book> executeQueryAll() {
		
		return dao.executeQueryAll();
	}
	
}
