package com.niit.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;



@Transactional
@Repository
public class CategoryDAOimpl implements CategoryDAO  {
		@Autowired
		SessionFactory sessionFactory;
		public void saveCategory(Category category) {
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		}
		
		public void deleteCategory(Category category) {
		
			sessionFactory.getCurrentSession().delete(category);
		}

	    public void editCategory(Category category)
	    {
	    	sessionFactory.getCurrentSession().update(category);
	    }
	    
	    public Category getCategory(int categoryID)
	    {
	    	
	    	return sessionFactory.getCurrentSession().get(Category.class, categoryID);
	    }   	
	    
	    public List<Category> getAllCategory() {
	    	System.out.println("In get all category method");
			return (List<Category>)sessionFactory.getCurrentSession().createQuery("from com.niit.model.Category").list();
		}

	}


