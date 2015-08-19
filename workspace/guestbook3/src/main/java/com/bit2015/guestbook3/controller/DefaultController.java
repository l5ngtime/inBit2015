package com.bit2015.guestbook3.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.guestbook3.dao.GuestBookDao;
import com.bit2015.guestbook3.vo.GuestBookVo;

@Controller
public class DefaultController {
	@Autowired
	private GuestBookDao dao;
	
	@RequestMapping("/")
	public String list(Model model) {
			List <GuestBookVo> list = dao.getList();
			model.addAttribute("list", list);
		return "index";

	}
	
	@RequestMapping("/add")
	public String form ( @ModelAttribute GuestBookVo vo){
			dao.insert(vo);
		return "redirect:/";
	} 
	
	@RequestMapping("/delete")
	public String delete ( @RequestParam int no, @RequestParam String password){
			dao.delete(no, password);
		return "redirect:/";
	} 
	
	@RequestMapping("/delform&{no}")
	public String delform ( @PathVariable("no") int no, Model model){
		model.addAttribute("no", no);
		return "deleteform";
	} 
}
