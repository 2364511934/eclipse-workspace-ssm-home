package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/user.do")
	public String login() {
		System.out.println("���յ�����");
		return "show";
	}
}
