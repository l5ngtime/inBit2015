package com.bit2015.springex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex2Controller {
	@RequestMapping("/index")
	public String index(){
		
		
		return "/WEB-INF/views/index.jsp";
	}
}
