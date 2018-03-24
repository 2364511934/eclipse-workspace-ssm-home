package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String filename = request.getParameter("filename");
		System.out.println("filename: " + filename);

		String path = request.getServletContext().getRealPath("/res");

		InputStream is = new FileInputStream(new File(path, filename));
		// 设置响应头 java.net.URLEncoder;
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));

		ServletOutputStream os = response.getOutputStream();

		byte[] b = new byte[1024];
		int len = -1;
		while ((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
		is.close();
		os.close();

		System.out.println("下载成功");

	}

}
