package serverlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BaseServerLet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("����:BaseServerLet");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("��ȡ����:getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("��ȡ��Ϣ:getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("��ʼ��:init");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("����:service");
	}

}
