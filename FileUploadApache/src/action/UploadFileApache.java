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
		// 1. 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// org.apache.commons.fileupload.disk.DiskFileItemFactory;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置存储临时文件  C 盘可能由于不是管理员权限而拒绝访问
		factory.setRepository(new File("D:\\"));
		// 设置缓冲区大小
		factory.setSizeThreshold(1024*1024);
		//解析请求(获取所有的表单元素(普通表单元素/文件表单元素))
		//ServletFileUpload核心:将所有的表单元素解析为Fileitem
		// org.apache.commons.fileupload.servlet.ServletFileUpload;
		ServletFileUpload upload  = new ServletFileUpload(factory);
		
		List<FileItem> items = null;
		try {
			items= upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		// 获取文件目录
		String path = request.getServletContext().getRealPath("/upload");
		
		for(FileItem fileItem  : items) {
			// 类型判断
			// 是否是表单
			if(fileItem.isFormField()) {
				String name = fileItem.getFieldName();
				String value = fileItem.getString();
				System.out.println("name:"+name+"\tvalue:"+value);
			}
			// 文件类型
			else {
				String name = fileItem.getName();
				try {
					fileItem.write(new File(path, name));
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("上传成功");
				
			}
		}
		
		
		
	}

}
