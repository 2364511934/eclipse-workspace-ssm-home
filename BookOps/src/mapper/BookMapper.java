package mapper;

import java.util.List;

import entity.Book;

public interface BookMapper {
	// 查询指定一个
	public Book selectBookOne(int bid);
	// 查询所有
	public List<Book> selectBookAll();
	// 增加一个
	public int insertBookOne(Book book);
	// 修改一个
	public int updateBookOne(Book book);
	// 删除一个
	public int deleteBookOne(int bid);
}
