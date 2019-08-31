package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartDAO {


	 public void saveCart(CartItem cart);
	 public void deleteCart(CartItem cart);	
	 public  CartItem getCart(int id);
     public List<CartItem> getAll();
     public List<CartItem> getcartByuserName(String username); 

}
