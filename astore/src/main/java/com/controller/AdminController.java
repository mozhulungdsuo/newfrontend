package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/adding",method = RequestMethod.GET)
	public ModelAndView adding(@ModelAttribute("list")Category category,@ModelAttribute("slist")Supplier supplier)
	{   ModelAndView mv=new ModelAndView("adding");
	    mv.addObject("list",productdao.retrieveCategory());
	    mv.addObject("slist",productdao.retrieveSupplier());
	    return mv;
		
	}
	@RequestMapping(value="/admin/saveCat",method=RequestMethod.POST)
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
	
	
	
	@RequestMapping(value="/admin/saveSup",method=RequestMethod.POST)
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
		prod.setPid(req.getParameter("pid"));	
		prod.setPname(req.getParameter("pname"));
		prod.setDescription(req.getParameter("description"));
		prod.setPrice(req.getParameter("price"));
		prod.setStock(req.getParameter("stock"));
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
		productdao.insertProduct(prod);
		try {
			byte [] imagebyte=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
			fos.write(imagebyte);
			fos.close();
			
		}catch(Exception e) {
			System.out.println("error");
			
		}
		    mv.setViewName("adding");
			return mv;
			
	}
	}
	