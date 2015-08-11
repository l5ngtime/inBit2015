package com.bit2015.emaillist3.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.emaillist3.dao.EmailListDao;
import com.bit2015.emaillist3.vo.EmailListVo;

@Controller
public class EmailListController {
	
	@Autowired
	private EmailListDao emailListDao;
	
	@RequestMapping( "/list" )
	public String list( Model model ) {
		try {
			List<EmailListVo> list = emailListDao.getList();
			model.addAttribute( "list", list );
			//model.addAttribute( list );
			
		} catch( SQLException ex ) {
			System.out.println( "DB Error:" + ex );
		}	
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping( "/inform" )
	public String inform() {
		return "/WEB-INF/views/form_emaillist.jsp";
	}
	
	@RequestMapping("/add")
	public String form ( @ModelAttribute EmailListVo vo){
		try {
			emailListDao.insert(vo);
		} catch (SQLException e) {
			System.out.println("db 오류 : " + e);
		}
		return "redirect:/list";
	}
	
}
