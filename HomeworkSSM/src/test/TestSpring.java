package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entity.Book;
import service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class TestSpring {
	
	@Autowired
	BookService service;
	
	@Test
	public void test() {
		List<Book> lists = service.queryAll();
		System.out.println(lists);
	}
}
