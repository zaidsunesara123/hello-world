package com.niit.dao;

import java.util.List;

import com.niit.model.Category;


public interface CategoryDAO {
	
	 public void saveCategory(Category category);
	 public void deleteCategory(Category category);
	 public void editCategory(Category category);
	 public Category getCategory(int categoryID);
     public List<Category> getAllCategory();


}
