package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class session
 */
@WebServlet("/session")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(name != null && pwd != null && name.equals("zs") && pwd.equals("123")) {
			// 校验成功
			request.getSession().setAttribute("user", name);
			//response.getWriter().println("登录成功");
			request.setAttribute("msg", "登录成功");
			System.out.println("验证通过");
		}
		else
		{ 
			// 校验失败
			request.setAttribute("msg", "登录成功");
			//response.getWriter().println("登录失败");
			System.out.println("验证不通过");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
