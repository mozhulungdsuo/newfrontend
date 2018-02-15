package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.dao.SupplierDao;
import com.backend.dao.UserDao;
import com.backend.daoimpl.SupplierDaoImpl;
import com.backend.daoimpl.UserDaoImpl;
import com.backend.model.Supplier;
import com.backend.model.User;







@Controller
public class IndexController {
	

	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new User());
	    return mav;
	  }
	  
	  @Autowired
	  UserDao userDao;
	  @RequestMapping(value="/save",method=RequestMethod.POST)
	  public ModelAndView saveUser(@ModelAttribute("user") User user) {
	  	ModelAndView mv=new ModelAndView();
	  	
	  	user.setRole("ROLE_USER");
	  	user.setEnabled(false);
	  	userDao.insertUser(user);
	  	mv.setViewName("index");
	  	return mv;
	  }
	



@RequestMapping(value="/")
public ModelAndView index()
{   ModelAndView mv=new ModelAndView();
    
	mv.setViewName("index");
	return mv;
}




}
