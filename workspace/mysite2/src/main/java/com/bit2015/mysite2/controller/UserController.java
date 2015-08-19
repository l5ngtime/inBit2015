package com.bit2015.mysite2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2015.mysite2.service.UserService;
import com.bit2015.mysite2.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping( "/joinform" )
	public String joinform() {
		return "user/joinform";
	}

	@RequestMapping( "/joinsuccess" )
	public String joinSuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping( "/loginform" )
	public String loginform() {
		return "user/loginform";
	}
	
	@RequestMapping( "/login" )
	public String login( HttpSession session, @ModelAttribute UserVo userVo ) {
		UserVo vo = userService.login( userVo );
		if( vo == null ) {
			return "redirect:/user/loginform";
		}
		
		// 로긴처리
		session.setAttribute( "authUser", vo );
		return "redirect:/";
	}
	
	@RequestMapping( "/logout" )
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping( "/join" )
	public String join( @ModelAttribute UserVo userVo ) {
		userService.join( userVo );
		return "redirect:/user/joinsuccess";
		//return "user/joinsuccess";
	}
	
	@RequestMapping( "/updateform" )
	public String updateform(HttpSession session, Model model) {
		UserVo svo=(UserVo)session.getAttribute("authUser");
		if(svo==null){
			return "redirect:/user/loginform";
		}
		return "user/updateform";
	}
	
	@RequestMapping( "/update" )
	public String update( HttpSession session,@ModelAttribute UserVo userVo, Model model, String wpassword) {
		UserVo svo=(UserVo)session.getAttribute("authUser");
		UserVo vo =userService.updateform(svo.getNo()); 
		if(vo.getPassword().equals(wpassword)==false){
			boolean error=true;
			model.addAttribute( "error", error );
			return "redirect:/user/updateform";
		}
		//request.setAttribute( "-", - );
		userService.update(userVo);
		return "user/updatesuccess";
	}
	
	@RequestMapping( "/updatesuccess" )
	public String updateSuccess() {
		return "user/updatesuccess";
	}
	
	//@RequestMapping( "/updateform" )
	//public String update(@ModelAttribute UserVo userVo) {
//		userService.updateform(userVo);
//		return "redirect:/user/updatesuccess";
//	}
}