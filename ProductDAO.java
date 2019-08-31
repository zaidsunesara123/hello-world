package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {

	 public void saveProduct(Product prod);
	 public void deleteProduct(Product prod);
	 public void editProduct(Product prod);
	 public Product getProduct(int pdId);
     public List<Product> getAllProduct();
     public List<Product> getProductsByCategory(int categoryid); 

}
