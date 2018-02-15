package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.backend.dao.CartDao;
import com.backend.dao.CategoryDao;
import com.backend.dao.OrderDao;
import com.backend.dao.ProductDao;
import com.backend.dao.SupplierDao;
import com.backend.dao.UserDao;

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




}
