package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

@Controller
public class UserController {
	/*@RequestMapping("/user.do")
	public String login(String user, String pwd, String[] hobby) {
		System.out.println("接收到请求");
		System.out.println("user:"+user);
		System.out.println("pwd:"+pwd);
		System.out.println("hobby:"+hobby[0]);
		System.out.println("hobby:"+hobby[1]);
		System.out.println("hobby:"+hobby[2]);
		return "show";
	}*/
	
	@RequestMapping("/user.do")
	public String login(User user) {
		System.out.println("接收到请求");
		System.out.println("user:"+user);
		
		return "show";
	}
}
