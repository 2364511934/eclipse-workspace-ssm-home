package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/login")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd= request.getParameter("pwd");
		System.out.println("name:"+name+"\tpwd:"+pwd);
		System.out.println("LoginServelet:service");
		request.setAttribute("msg", "µÇÂ¼³É¹¦");
		response.getWriter().write("µÇÂ¼");
		//request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
