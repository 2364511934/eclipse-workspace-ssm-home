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
	
	// 查询指定的几个 注意不能实现重载 mybatis 搞不定 不能写成  selectBookAll
	public List<Book> selectBookAll2(Book book);
	
	// 查询指定的几个 注意不能实现重载 mybatis 搞不定 不能写成  selectBookAll
	public List<Book> selectBookAll3(Book book);
	
	// 查询指定的几个 使用foreach
	public List<Book> selectBookByForeach(List<Integer> lists);
}
