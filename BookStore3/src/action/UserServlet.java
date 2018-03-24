package action;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 2. �����û�����
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		
		// 3. У���û����� ���� UserDao
		UserService userService = new UserServiceImpl();
		int rows = userService.QueryOne(user, pwd);
		// ���û�����
		if(rows> 0) {
			// ��¼�û����� ���ڼ�¼�û���
			request.getSession().setAttribute("user", user);
			//request.setAttribute("msg", "��¼�ɹ�");
			request.getRequestDispatcher("book").forward(request, response);
		}
		else {
			request.setAttribute("msg", "��¼ʧ��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		   
		
	}

}
