package com.example.helloNcp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/welcome.html")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	

	@RequestMapping("/")
	public ModelAndView rootPage() {
		return new ModelAndView("welcome");
	}
}