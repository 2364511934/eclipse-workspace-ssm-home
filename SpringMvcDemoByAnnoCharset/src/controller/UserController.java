package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/user.do")
	public String login(Model model) {
		System.out.println("���յ�����");
		model.addAttribute("msg", "����");
		return "show";
	}
}
