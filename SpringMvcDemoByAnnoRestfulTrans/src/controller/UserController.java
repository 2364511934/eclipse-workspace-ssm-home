package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/delete/{userid}")
	public String delete(@PathVariable int userid ) {
		System.out.println("接收到请求");
		System.out.println("userid:"+userid);
		return "show";
	}
	
	@RequestMapping("login")
	public String login(Model model){
		model.addAttribute("hello", "login");
		return "forward:/query";
	}
	
	@RequestMapping("query")
	public String query() {
		return "show";
	}
	
	
}
