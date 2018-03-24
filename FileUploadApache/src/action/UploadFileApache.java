package action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFileApache
 */
@WebServlet("/uploadfileapache")
public class UploadFileApache extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// org.apache.commons.fileupload.disk.DiskFileItemFactory;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ���ô洢��ʱ�ļ�  C �̿������ڲ��ǹ���ԱȨ�޶��ܾ�����
		factory.setRepository(new File("D:\\"));
		// ���û�������С
		factory.setSizeThreshold(1024*1024);
		//��������(��ȡ���еı�Ԫ��(��ͨ��Ԫ��/�ļ���Ԫ��))
		//ServletFileUpload����:�����еı�Ԫ�ؽ���ΪFileitem
		// org.apache.commons.fileupload.servlet.ServletFileUpload;
		ServletFileUpload upload  = new ServletFileUpload(factory);
		
		List<FileItem> items = null;
		try {
			items= upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		// ��ȡ�ļ�Ŀ¼
		String path = request.getServletContext().getRealPath("/upload");
		
		for(FileItem fileItem  : items) {
			// �����ж�
			// �Ƿ��Ǳ�
			if(fileItem.isFormField()) {
				String name = fileItem.getFieldName();
				String value = fileItem.getString();
				System.out.println("name:"+name+"\tvalue:"+value);
			}
			// �ļ�����
			else {
				String name = fileItem.getName();
				try {
					fileItem.write(new File(path, name));
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("�ϴ��ɹ�");
				
			}
		}
		
		
		
	}

}
