package com.backend.dao;

import java.util.ArrayList;
import java.util.List;

import com.backend.model.Category;
import com.backend.model.Product;
import com.backend.model.Supplier;

public interface ProductDao {
	public void insertProduct(Product product);
	public void deleteProduct(Product product);
	public List<Category> retrieveCategory();	
	public List<Supplier> retrieveSupplier();
	public Category CgetByID(String cid);
	public Supplier SgetByID(String sid);
	public List<Product> retrieveProducts();
	public Product getProductbyID(int pid);
	
}
