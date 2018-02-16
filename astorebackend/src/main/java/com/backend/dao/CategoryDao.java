package com.backend.dao;

import java.util.List;

import com.backend.model.Category;
import com.backend.model.Product;

public interface CategoryDao {
public void insertCategory(Category category);
public void deleteCategory(Category category);
public List<Product> retrieveProduct(String cid);
}
