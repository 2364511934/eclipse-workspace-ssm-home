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
			// У��ɹ�
			request.getSession().setAttribute("user", name);
			//response.getWriter().println("��¼�ɹ�");
			request.setAttribute("msg", "��¼�ɹ�");
			System.out.println("��֤ͨ��");
		}
		else
		{ 
			// У��ʧ��
			request.setAttribute("msg", "��¼�ɹ�");
			//response.getWriter().println("��¼ʧ��");
			System.out.println("��֤��ͨ��");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
