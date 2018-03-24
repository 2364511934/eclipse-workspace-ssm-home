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
		
		//1.设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 2. 接收用户数据
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		
		// 3. 校验用户数据 生成 UserDao
		UserService userService = new UserServiceImpl();
		int rows = userService.QueryOne(user, pwd);
		// 有用户数据
		if(rows> 0) {
			// 记录用户数据 用于记录用户名
			request.getSession().setAttribute("user", user);
			//request.setAttribute("msg", "登录成功");
			request.getRequestDispatcher("book").forward(request, response);
		}
		else {
			request.setAttribute("msg", "登录失败");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		   
		
	}

}
