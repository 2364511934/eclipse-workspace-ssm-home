package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import service.IBookService;
import service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 2.���û�����
		
		// 3.��ѯ���ݿ� ��ȡ����
		IBookService bookService = new BookServiceImpl();
		List<Book> books = bookService.executeQueryAll();
		
		// ���������
		request.getSession().setAttribute("books", books);
		
		// ��ת��չʾ����
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
	}

}
