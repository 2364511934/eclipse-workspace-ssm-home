package dao;

import java.util.List;

import entity.Book;

class DaoBook extends BaseDao {

	// ���� ����
	protected int insertBook(String sql, Object[] param) {
		return executeUpdate(sql, param);
	}

	// �޸�����
	protected int updateBook(String sql, Object[] param) {
		return executeUpdate(sql, param);
	}

	// ɾ������
	protected int deleteBook(String sql, Object[] param) {
		return executeUpdate(sql, param);
	}

	// ��ѯ
	protected <Book> List<Book> queryBook(String sql, Object[] param, Class<?> Book) throws Exception {
		return executeQuery(sql, param, Book);
	}
}

class DaoBookCon extends DaoBook {
	// ������
	public int insertBookCon(Book b) {
		String sql = "insert into book values(?, ?, ?, ?)";
		Object[] param = new Object[4];
		param[0] = b.getCid();
		param[1] = b.getCname();
		param[2] = b.getAuthor();
		param[3] = b.getPrice();
		return insertBook(sql, param);
	}

	// �޸���
	public int updateBookCon(int bid, double price) {
		String sql = "update book set price = ? where bid = ?";
		Object[] param = new Object[2];
		param[0] = price;
		param[1] = bid;
		return updateBook(sql, param);
	}

	// ɾ�� ��
	public int deleteBookCon(int bid) {
		String sql = "delete from book  where bid = ?";
		Object[] param = new Object[1];
		param[0] = bid;
		return deleteBook(sql, param);
	}

	// ��ѯ��
	public <Book> List<Book> queryBookCon(int bid) throws Exception {
		String sql = "select *  from book  where bid = ?";
		Object[] param = new Object[1];
		param[0] = bid;
		return queryBook(sql, param, entity.Book.class);
	}

	public <Book> List<Book> QueryBookCon() throws Exception {
		String sql = "select *  from book";
		Object[] param = new Object[0];
		return queryBook(sql, param, entity.Book.class);
	}

	public <Book> List<Book> QueryBookCon(String cname) throws Exception {
		String sql = "select *  from book where bname like ? ";
		Object[] param = new Object[1];
		param[0] = cname;
		return queryBook(sql, param, entity.Book.class);
	}
}

public class DaoBookDemo {

	public static void main(String[] args) throws Exception {
		// ���������
		/*entity.Book book1 = new entity.Book(1, "��������", "�޹���", 20.5);
		entity.Book book2 = new entity.Book(2, "���μ�", "��ж�", 20);
		entity.Book book3 = new entity.Book(3, "ˮ䰴�", "ʩ����", 20.5);

		entity.Book[] books = new entity.Book[] { book1, book2, book3 };

		DaoBookCon daoBookCon = new DaoBookCon();
		for (entity.Book book : books) {
			System.out.println(daoBookCon.insertBookCon(book));
		}*/

		// ��ѯ���Ϊ3����
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon(); List<Book> lists =
		 * daoBookCon.queryBookCon(3);
		 * 
		 * for(entity.Book book : lists) { System.out.println(book); }
		 */

		// ��ѯ���е���
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon(); List<Book> lists =
		 * daoBookCon.QueryBookCon();
		 * 
		 * for(entity.Book book : lists) { System.out.println(book); }
		 */

		// �޸�bid = 3 �ļ۸�
        /*
		DaoBookCon daoBookCon = new DaoBookCon();
		System.out.println(daoBookCon.updateBookCon(3, 55.5));*/

		// ɾ��bid = 2 ��ͼ��
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon();
		 * System.out.println(daoBookCon.deleteBookCon(2));
		 */

		// ��ѯ����������
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon(); List<Book> lists =
		 * daoBookCon.QueryBookCon("%��%");
		 * 
		 * for (entity.Book book : lists) { System.out.println(book); }
		 */

	}

}
