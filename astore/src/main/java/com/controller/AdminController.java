package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.backend.dao.CategoryDao;
import com.backend.dao.ProductDao;
import com.backend.dao.SupplierDao;
import com.backend.model.Category;
import com.backend.model.Product;
import com.backend.model.Supplier;
import com.backend.model.User;



@Controller
public class AdminController {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productdao;
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/admin/productAdminList")
	public ModelAndView productAdminList()
		{  
		   ModelAndView mv=new ModelAndView("productAdminList");
		   mv.addObject("abc",productdao.retrieveProducts());
		   
		return mv;
		
	  }
	@RequestMapping(value="/updateProd",method=RequestMethod.GET)
	public ModelAndView updateProd(@RequestParam("pid") String pid)
	{   //int ppid=Integer.parseInt(pid);
		//Product product=productdao.getProductbyID(pid);
		//product.setDescription(description);
		ModelAndView mv=new ModelAndView("updateProd");
		int ppid=Integer.parseInt(pid);
	    mv.addObject("item",productdao.getProductbyID(ppid));
	    mv.addObject("list",productdao.retrieveCategory());
	    mv.addObject("slist",productdao.retrieveSupplier());
	    
		return mv;
	}
	@RequestMapping(value="/deleteProd",method=RequestMethod.GET)
	public ModelAndView deleteProd(@RequestParam("pid") String pid)
	{   int ppid=Integer.parseInt(pid);
		Product product=productdao.getProductbyID(ppid);
		productdao.deleteProduct(product);
	    
		   ModelAndView mv=new ModelAndView("productAdminList");
		   mv.addObject("abc",productdao.retrieveProducts());
		   
	      return mv;
	}
	
	@RequestMapping(value="/admin/adding",method = RequestMethod.GET)
	public ModelAndView adding(@ModelAttribute("list")Category category,@ModelAttribute("slist")Supplier supplier)
	{   ModelAndView mv=new ModelAndView("adding");
	    mv.addObject("list",productdao.retrieveCategory());
	    mv.addObject("slist",productdao.retrieveSupplier());
	    return mv;
		
	}
	
	/*@RequestMapping(value="/userLogged", method = RequestMethod.GET)
	public String userlogged(ModelMap model,Principal principal) {
	
	//String currentuser =principal.getName();
	 model.addAttribute("currentuser", getPrincipal());
     return "index";
	}
	*/
	@RequestMapping(value="/saveCat",method=RequestMethod.POST)
	public ModelAndView saveCategoryData(@RequestParam("cid")  String cid,@RequestParam("cname") String cname)
	{
		ModelAndView mv=new ModelAndView();
		Category s=new Category();
		s.setCid(cid);
		s.setCname(cname);
		categoryDao.insertCategory(s);{
			
		}
		mv.setViewName("adding");
		return mv;
	}
	
	
	
	@RequestMapping(value="/saveSup",method=RequestMethod.POST)
	public ModelAndView saveSupplierData(@RequestParam("sid")  String sid,@RequestParam("sname") String sname)
	{
		ModelAndView mv=new ModelAndView();
		Supplier s=new Supplier();
		s.setSid(sid);
		s.setSupplierName(sname);
		supplierDao.insertSupplier(s);{
			
		}
		mv.setViewName("adding");
		return mv;
	}
	@RequestMapping(value="/saveProd",method=RequestMethod.POST)
	public ModelAndView SaveProduct(HttpServletRequest req,@RequestParam("file")MultipartFile file)
	{
		ModelAndView mv=new ModelAndView();
		Product prod=new Product();
		//int ppid=Integer.parseInt(req.getParameter("pid"));
		//prod.setPid(ppid);
		//System.out.println(req.getParameter("pid"));
		prod.setPname(req.getParameter("pname"));
		prod.setDescription(req.getParameter("description"));
		prod.setPrice(req.getParameter("price"));
		prod.setStock(req.getParameter("Stock"));
		//prod.setCategory(req.getParameter(""));
		String cid=req.getParameter("cid");
		String sid=req.getParameter("sid");
		System.out.println(cid);
		prod.setCategory(productdao.CgetByID(cid));
		prod.setSupplier(productdao.SgetByID(sid));
		
		
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		System.out.println(filename);
		prod.setImgname(filename);
		System.out.println(filepath+filename);
		productdao.insertProduct(prod);
		try {
			byte [] imagebyte=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+filename));
			System.out.println(filepath+filename);
			fos.write(imagebyte);
			fos.close();
			
		}catch(Exception e) {
			System.out.println("error");
			
		}   //mv.addObject("abc",productdao.retrieveProducts());
		    mv.setViewName("adding");
			return mv;
			
	}
	@RequestMapping(value="/saveProd1",method=RequestMethod.POST)
	public ModelAndView saveProd1(HttpServletRequest req,@RequestParam("file")MultipartFile file)
	{
		int ppid=Integer.parseInt(req.getParameter("pid"));
		Product prod=productdao.getProductbyID(ppid);
		//prod.setPid(req.getParameter("pid"));
		System.out.println(req.getParameter("pid"));
		prod.setPname(req.getParameter("pname"));
		prod.setDescription(req.getParameter("description"));
		prod.setPrice(req.getParameter("price"));
		prod.setStock(req.getParameter("stock"));
		//prod.setCategory(req.getParameter(""));
		String pid=req.getParameter("pid");
		String cid=req.getParameter("cid");
		String sid=req.getParameter("sid");
		System.out.println(cid);
		prod.setCategory(productdao.CgetByID(cid));
		prod.setSupplier(productdao.SgetByID(sid));
		
		
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		System.out.println(filename);
		prod.setImgname(filename);
		productdao.insertProduct(prod);
		try {
			byte [] imagebyte=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+filename));
			fos.write(imagebyte);
			fos.close();
			
		}catch(Exception e) {
			System.out.println("error");
			
		}
		//redirectAttributes.addFlashAttribute("pid", pid);
		//ModelAndView mv=new ModelAndView("updateProd");
		//int ppid=Integer.parseInt(pid);
	   //mv.addObject("item",productdao.getProductbyID(ppid));
	   // mv.addObject("list",productdao.retrieveCategory());
	    ////mv.addObject("slist",productdao.retrieveSupplier());
	    
		// mv.setViewName("adding");
		 //ModelAndView mv=new ModelAndView("productAdminList");
		  // mv.addObject("abc",productdao.retrieveProducts());
		ModelAndView mv=new ModelAndView("productAdminList");
		   mv.addObject("abc",productdao.retrieveProducts());
		   
	      return mv;
	     
	}
	
	
	
	
	
	
	/*private String getPrincipal(){
        
		  String email = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            email = ((UserDetails)principal).getUsername();
	        } else {
	            email = principal.toString();
	        }
	        return email;
      
    }*/
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "redirect:/";
	}
	@RequestMapping("/accessDenied")
	public String Error()
	{
		System.out.println("Invalid username or password");
		return "error";
	}


	
	
	}
	