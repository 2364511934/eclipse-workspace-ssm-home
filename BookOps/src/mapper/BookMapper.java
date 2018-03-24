package mapper;

import java.util.List;

import entity.Book;

public interface BookMapper {
	// ��ѯָ��һ��
	public Book selectBookOne(int bid);
	// ��ѯ����
	public List<Book> selectBookAll();
	// ����һ��
	public int insertBookOne(Book book);
	// �޸�һ��
	public int updateBookOne(Book book);
	// ɾ��һ��
	public int deleteBookOne(int bid);
}
