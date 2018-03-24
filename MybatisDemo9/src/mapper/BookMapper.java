package mapper;

import java.util.List;

import entity.Book;

public interface BookMapper {
	List<Book> QueryAll(Book book);
}
