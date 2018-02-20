package com.backend.dao;

import com.backend.model.Cart;

public interface CartDao {
	public void insertCart(Cart cart);
public Cart getCartById(String pid,String email);
}
