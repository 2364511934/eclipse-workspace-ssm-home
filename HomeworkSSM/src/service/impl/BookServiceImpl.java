package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Book;
import mapper.BookMapper;
import service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper mapper;
	
	@Override
	public List<Book> queryAll(){
		return mapper.queryAll();
	}
}
