package action;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter:init()");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*((HttpServletRequest)request).setCharacterEncoding("utf-8");
		((HttpServletResponse)response).setCharacterEncoding("utf-8");
		((HttpServletResponse)response).setContentType("text/html;charset=utf-8"); */
		System.out.println("doFilter:接收到请求");
		chain.doFilter(request, response);
		System.out.println("doFilter:处理了请求");
	}
	@Override
	public void destroy() {
		System.out.println("MyFilter:destroy()");
	}

}
