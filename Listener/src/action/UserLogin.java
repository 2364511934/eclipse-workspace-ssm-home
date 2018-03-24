package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserLogin : service");
		request.setAttribute("user", "user");
		System.out.println("Ôö¼Óuser");
		request.setAttribute("user", "user");
		System.out.println("Ìæ»»user");
		request.removeAttribute("user");
		System.out.println("É¾³ýuser");
	}

}
