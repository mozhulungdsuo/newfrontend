package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="CartDetails")
public class Cart {
	@Id
	@GeneratedValue
	private int cartid;
	private String cartProductID;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="email")
	private User cartUserDetails;
	private double cartprice;
	private int cartQuantity;
	
	private String cartImage;
	private String cartProductName;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getCartProductID() {
		return cartProductID;
	}
	public void setCartProductID(String pid) {
		this.cartProductID = pid;
	}
	public User getCartUserDetails() {
		return cartUserDetails;
	}
	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}
	public double getCartprice() {
		return cartprice;
	}
	public void setCartprice(double d) {
		this.cartprice = d;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public String getCartImage() {
		return cartImage;
	}
	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}
	public String getCartProductName() {
		return cartProductName;
	}
	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}

	
	
	

}
