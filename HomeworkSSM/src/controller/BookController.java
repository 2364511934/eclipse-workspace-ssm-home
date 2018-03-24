package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.BookService;

@Controller
public class BookController  {
	
	@Autowired
	BookService service;

	@RequestMapping("/book")
	public String query(Model model) {
		
		model.addAttribute("books", service.queryAll());
		
		return "show";	
	}

	
}
