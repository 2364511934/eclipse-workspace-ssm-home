package action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 2.无用户数据
		
		// 3.查询数据库 获取数据
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.executeQueryAll();
		
		// 将结果返回
		request.getSession().setAttribute("books", books);
		
		// 跳转至展示界面
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
	}

}
