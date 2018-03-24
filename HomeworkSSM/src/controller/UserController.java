package controller;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.ControllerAdviceBean;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
import service.UserService;

@Controller
public class UserController implements org.springframework.web.servlet.mvc.Controller{
	@Autowired
	UserService service;
	
	@RequestMapping("/login")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView();
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		System.out.println("uname:"+uname);
		System.out.println("pwd:"+pwd);
		
		User user = new User();
		user.setUname(uname);
		user.setPwd(pwd);
		
		List<User> lists = service.queryOne(user);
		if(lists.isEmpty()) {
			System.out.println("û�д��û�������");
			view.setViewName("loginf");
			//view.addObject(attributeName, attributeValue)
			view.addObject("msg", "��¼ʧ��");
		}
		else {
			//System.out.println("�ҵ�");
			view.setViewName("forward:book");
		}
		
		return view;
	}

	
	
	/*@RequestMapping("/login2")
	public String login2(Model model, String uname, String pwd) {
		//ModelAndView view = new ModelAndView();
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		System.out.println("uname:"+uname);
		System.out.println("pwd:"+pwd);
		
		User user = new User();
		user.setUname(uname);
		user.setPwd(pwd);
		
		List<User> lists = service.queryOne(user);
		if(lists.isEmpty()) {
			model.addAttribute("msg", "��¼ʧ��");
			System.out.println("δ�Ҵ�");
			return "loginf";
		}
		else {
			System.out.println("�ҵ�");
		}
		
		return "forward:book";
	}*/
	
	
}
