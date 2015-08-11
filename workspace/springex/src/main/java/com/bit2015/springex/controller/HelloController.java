package com.bit2015.springex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.springex.dao.HelloDao;

@Controller
public class HelloController {
	@Autowired
	private HelloDao helloDao;

	@RequestMapping("/hello")
	public String hello(@RequestParam(required=false) String name, Model model) {
		
		helloDao.hello();
		model.addAttribute("name", name );
		
		return "/index.jsp";

	}
}