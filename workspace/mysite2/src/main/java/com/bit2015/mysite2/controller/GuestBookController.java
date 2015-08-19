package com.bit2015.mysite2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite2.service.GuestBookService;
import com.bit2015.mysite2.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	GuestBookService guestbookService;
	
	@RequestMapping( "/list" )
	public String list(Model model) {
		List<GuestBookVo> list = guestbookService.list();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@RequestMapping( "/deleteform" )
	public String deleteform() {
		return "guestbook/deleteform";
	}
	
	@RequestMapping( "/delete" )
	public String delete(@RequestParam long no, @RequestParam String password ) {
		guestbookService.delete(no, password);
		return "redirect:/guestbook/list";
	}

}