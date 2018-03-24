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
	
	// ��ѯָ���ļ��� ע�ⲻ��ʵ������ mybatis �㲻�� ����д��  selectBookAll
	public List<Book> selectBookAll2(Book book);
	
	// ��ѯָ���ļ��� ע�ⲻ��ʵ������ mybatis �㲻�� ����д��  selectBookAll
	public List<Book> selectBookAll3(Book book);
	
	// ��ѯָ���ļ��� ʹ��foreach
	public List<Book> selectBookByForeach(List<Integer> lists);
}
