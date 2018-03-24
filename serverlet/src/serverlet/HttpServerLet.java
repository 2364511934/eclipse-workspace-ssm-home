package serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServerLet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		System.out.println(method);

		String addr = req.getRemoteAddr();
		System.out.println(addr);
		// servlet4?user=xx&pwd=XX
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");

		System.out.println("user=" + user + ",pwd=" + pwd);

		System.out.println("HttpServerLet:get");
		
		PrintWriter writer = resp.getWriter();
		//通过流将数据返回给客户端(jsp)
		/*writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		*/
		writer.println("<html>");
		writer.println("success");
		writer.println("</html>");
		//释放资源
		writer.close();

		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HttpServerLet:post");
		String method = req.getMethod();
		System.out.println(method);

		String addr = req.getRemoteAddr();
		System.out.println(addr);
		// servlet4?user=xx&pwd=XX
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");

		System.out.println("user=" + user + ",pwd=" + pwd);

		System.out.println("HttpServerLet:get");
		
		PrintWriter writer = resp.getWriter();
		//通过流将数据返回给客户端(jsp)
		/*writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		*/
		writer.println("<html>");
		writer.println("success");
		writer.println("</html>");
		//释放资源
		writer.close();
		super.doPost(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("HttpServerLet:server");
		super.service(arg0, arg1);
	}
	
}
