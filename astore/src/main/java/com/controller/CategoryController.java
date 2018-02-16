package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backend.dao.CategoryDao;
import com.backend.dao.ProductDao;
import com.backend.dao.SupplierDao;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productdao;
	@Autowired
	SupplierDao supplierDao;
	@RequestMapping(value="productCustList",method = RequestMethod.GET)
	public ModelAndView productCustList(@RequestParam("cid") String cid)
		{  
		//String cid="88";
		System.out.println(cid);
		ModelAndView mv=new ModelAndView("productCustList");
	    mv.addObject("items",categoryDao.retrieveProduct(cid));
	    
	    return mv;
		
	}
}
