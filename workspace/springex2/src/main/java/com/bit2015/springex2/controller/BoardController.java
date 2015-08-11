package com.bit2015.springex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@ResponseBody
	@RequestMapping
	public String list(/*@RequestParam(value="page", required=false)*/String page){
		return "BoardController:list("+page+")";
	}
	@ResponseBody
	@RequestMapping
	public String list1(@RequestParam String page){
		return "BoardController:list("+page+")";
	}
	@ResponseBody
	@RequestMapping
	public String list2(@RequestParam(required=false, defaultValue="1") String page){
		return "BoardController:list("+page+")";
	}
	@ResponseBody
	@RequestMapping
	public String list3(@RequestParam(required=false, defaultValue="1") int page){
		return "BoardController:list("+page+")";
	}
	@ResponseBody
	@RequestMapping
	public String list4(@RequestParam(value="p", required=false, defaultValue="1") int page){
		return "BoardController:list("+page+")";
	}
	
	@ResponseBody
	@RequestMapping("/view/{no}")
	public String view2(@PathVariable("no") long no){
		return "BoardController:view("+no+")";
	}
	
	@ResponseBody
	@RequestMapping
	public String view(@RequestParam(required=false, defaultValue="1") long no){
		return "BoardController:view("+no+")";
	}
	
	@RequestMapping
	public ModelAndView modify(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/board/modify.jsp");
		mav.addObject("number", new Integer(10));
		mav.addObject("name", "박재현");
		
		return mav;
	}
	
	@RequestMapping
	public String modify2(Model model){
		model.addAttribute("number", new Integer(20));
		model.addAttribute("name", "l5ngtime");
		return "/WEB-INF/views/board/modify.jsp";
	}

}
