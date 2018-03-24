package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadFileOriginal
 */
@WebServlet("/uploadoriginal")
public class UploadFileOriginal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// û�а취��ȡ�ļ�����????
		// 2. ��ȡ�ļ���
		InputStream is = request.getInputStream();
		
		// 3. /upload ���ļ�·��
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println("upload:"+path);
		
		OutputStream os = new FileOutputStream(new File(path, "a.txt"));
		
		byte[] b = new byte[1024];
		int len = -1;
		while((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
		os.close();
		is.close();
		System.out.println("�ϴ����");
		
	}

}
