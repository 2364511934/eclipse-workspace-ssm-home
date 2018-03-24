package dao;

import java.util.List;

import entity.Book;

class DaoBook extends BaseDao {

	// 插入 数据
	protected int insertBook(String sql, Object[] param) {
		return executeUpdate(sql, param);
	}

	// 修改数据
	protected int updateBook(String sql, Object[] param) {
		return executeUpdate(sql, param);
	}

	// 删除数据
	protected int deleteBook(String sql, Object[] param) {
		return executeUpdate(sql, param);
	}

	// 查询
	protected <Book> List<Book> queryBook(String sql, Object[] param, Class<?> Book) throws Exception {
		return executeQuery(sql, param, Book);
	}
}

class DaoBookCon extends DaoBook {
	// 插入书
	public int insertBookCon(Book b) {
		String sql = "insert into book values(?, ?, ?, ?)";
		Object[] param = new Object[4];
		param[0] = b.getCid();
		param[1] = b.getCname();
		param[2] = b.getAuthor();
		param[3] = b.getPrice();
		return insertBook(sql, param);
	}

	// 修改书
	public int updateBookCon(int bid, double price) {
		String sql = "update book set price = ? where bid = ?";
		Object[] param = new Object[2];
		param[0] = price;
		param[1] = bid;
		return updateBook(sql, param);
	}

	// 删除 书
	public int deleteBookCon(int bid) {
		String sql = "delete from book  where bid = ?";
		Object[] param = new Object[1];
		param[0] = bid;
		return deleteBook(sql, param);
	}

	// 查询书
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
		// 添加三本书
		/*entity.Book book1 = new entity.Book(1, "三国演义", "罗贯中", 20.5);
		entity.Book book2 = new entity.Book(2, "西游记", "吴承恩", 20);
		entity.Book book3 = new entity.Book(3, "水浒传", "施耐庵", 20.5);

		entity.Book[] books = new entity.Book[] { book1, book2, book3 };

		DaoBookCon daoBookCon = new DaoBookCon();
		for (entity.Book book : books) {
			System.out.println(daoBookCon.insertBookCon(book));
		}*/

		// 查询编号为3的书
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon(); List<Book> lists =
		 * daoBookCon.queryBookCon(3);
		 * 
		 * for(entity.Book book : lists) { System.out.println(book); }
		 */

		// 查询所有的书
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon(); List<Book> lists =
		 * daoBookCon.QueryBookCon();
		 * 
		 * for(entity.Book book : lists) { System.out.println(book); }
		 */

		// 修改bid = 3 的价格
        /*
		DaoBookCon daoBookCon = new DaoBookCon();
		System.out.println(daoBookCon.updateBookCon(3, 55.5));*/

		// 删除bid = 2 的图书
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon();
		 * System.out.println(daoBookCon.deleteBookCon(2));
		 */

		// 查询带有三的书
		/*
		 * DaoBookCon daoBookCon = new DaoBookCon(); List<Book> lists =
		 * daoBookCon.QueryBookCon("%三%");
		 * 
		 * for (entity.Book book : lists) { System.out.println(book); }
		 */

	}

}
