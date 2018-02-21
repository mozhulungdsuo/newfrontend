package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/userLogged")
	public String goToLogin(@RequestParam(value="error",required=false)String error,@RequestParam(value="logout",required=false)String logout,Model model)
	{
		
		
		if(error!=null)
			model.addAttribute("error", "Invalid email and password");
		
		if(logout!=null)
			model.addAttribute("logout","you have logged out sucessfully");
			
		return "index";
	}
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	@RequestMapping("/register")
	public ModelAndView reg(){
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
}
