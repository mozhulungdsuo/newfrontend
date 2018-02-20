package com.backend.dao;

import java.util.List;

import com.backend.model.Cart;

public interface CartDao {
	public void insertCart(Cart cart);
public Cart getCartById(String pid,String email);
public List<Cart> retrieveCart(int cid);
}
