package com.bit2015.springex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//join이란 값이 get방식으로 들어올 시
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String joinform(){
		return "/WEB-INF/views/user/joinform.jsp";
	}
	
	//join이란 값이 post방식으로 들어올 시 
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(){
		return "redirect:/index";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(){
		return "login page";
		
	}
}
