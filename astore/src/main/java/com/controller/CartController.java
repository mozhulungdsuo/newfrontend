package com.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backend.dao.CartDao;
import com.backend.dao.CategoryDao;
import com.backend.dao.OrderDao;
import com.backend.dao.ProductDao;
import com.backend.dao.SupplierDao;
import com.backend.dao.UserDao;
import com.backend.model.Cart;
import com.backend.model.Product;
import com.backend.model.User;

@Controller
public class CartController {
int x;
@Autowired
CategoryDao categoryDao;
@Autowired
ProductDao productdao;
@Autowired
SupplierDao supplierDao;
@Autowired
UserDao userdao;
@Autowired
CartDao cartdao;
@Autowired
OrderDao orderdao;

@RequestMapping(value="checkOut")
public ModelAndView checkOut()
{
	return null;
}
@RequestMapping(value="deletePCart",method=RequestMethod.GET)
public ModelAndView deleteProd(@RequestParam("pid") String pid,HttpServletRequest request)
{   
	ModelAndView mv=new ModelAndView("cart");
	int ppid=Integer.parseInt(pid);
	//int ccartid=Integer.parseInt(cartid);
	Principal principal=request.getUserPrincipal();
	String email=principal.getName();

	Cart cr=cartdao.getCartById(ppid, email);
	cartdao.deleteProdCart(cr);
	return mv;
}

@RequestMapping(value="addToCart",method=RequestMethod.GET)
public ModelAndView addToCart(HttpServletRequest request)
{   
	
	ModelAndView mv=new ModelAndView("cart");
	Principal principal=request.getUserPrincipal();
	String email=principal.getName();
	System.out.println(email);
	//try {
		String pid=request.getParameter("pid");
		System.out.println(pid);
		int ppid=Integer.parseInt(pid);
		System.out.println(request.getParameter("price"));
		Double price=Double.parseDouble(request.getParameter("price"));
		System.out.println(price);
				int quantity=Integer.parseInt(request.getParameter("quantity"));
				System.out.println(quantity);
		String productname=request.getParameter("pname");
		String imgname=request.getParameter("imgname");
		Cart cartexist=cartdao.getCartById(ppid,email);
		
		if(cartexist==null)
		{
			Cart cm=new Cart();
			cm.setCartProductID(pid);
			cm.setCartImage(imgname);
			cm.setCartProductName(productname);
			cm.setCartQuantity(quantity);
			cm.setCartprice(price*quantity);
			cm.setCartUserDetails(userdao.getUserById(email));
			cartdao.insertCart(cm);
			//cartdao.retrieveCart(cm.getCartid());
			mv.addObject("carts",cartdao.retrieveCart(cm.getCartid()));
		}
		else {
			//give some alert or maybe directly go checkout
			//add same object to db???
		}
			
	
	
	//}finally {
		
	//}
		
	return mv;
	
}
}



