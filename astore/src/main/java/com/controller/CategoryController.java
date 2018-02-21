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
import com.backend.model.Product;
import com.backend.model.Supplier;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productdao;
	@Autowired
	SupplierDao supplierDao;
	@RequestMapping(value="/productCustList",method = RequestMethod.GET)
	public ModelAndView productCustList(@RequestParam("cid") String cid)
		{  
		//String cid="88";
		System.out.println(cid);
		ModelAndView mv=new ModelAndView("productCustList");
	    mv.addObject("items",categoryDao.retrieveProduct(cid));
	    
	    return mv;
		
	}
	@RequestMapping(value="/productDetails",method = RequestMethod.GET)
	public ModelAndView productDetails(@RequestParam("pid") String pid)
		{  
		//String cid="88";
		System.out.println(pid);
		int ppid=Integer.parseInt(pid);
		//Product product=new Product();
		ModelAndView mv=new ModelAndView("productDetails");
		Product product=productdao.getProductbyID(ppid);
	    mv.addObject("item",product);
	    Supplier supplier=product.getSupplier();
	    mv.addObject("sup",supplier);
	    
	    
	    return mv;
		
	}
}
