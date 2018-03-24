package service.impl;

import java.util.List;

import bean.Book;
import dao.IBookDao;
import dao.impl.BookDaoImpl;
import service.IBookService;

public class BookServiceImpl implements IBookService {
	private IBookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> executeQueryAll() {
		// TODO Auto-generated method stub
		return bookDao.executeQueryAll();
	}

}
