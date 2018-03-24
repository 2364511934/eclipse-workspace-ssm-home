package dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dao.BookDao;
import entity.Book;

@Repository
public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

	// 注入ds给JdbcDaoSupport
	@Autowired
	public void setDataSource0(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public List<Book> queryAll() {
		// 先配置数据源
		return getJdbcTemplate().query("select * from book", new BeanPropertyRowMapper(Book.class));

	}

}
