package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.h2.engine.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;
@Transactional
@Repository
public class ProductDAOimpl implements ProductDAO {
	@Autowired
	
	SessionFactory sessionFactory;
	
	public void saveProduct(Product prod) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(prod);
	}
	
	public void deleteProduct(Product prod) {
	
		sessionFactory.getCurrentSession().delete(prod);
	}

    public void editProduct(Product prod)
    {
    	sessionFactory.getCurrentSession().update(prod);
    }
    
    public Product getProduct(int ProductID)
    {
    	
		return sessionFactory.getCurrentSession().get(Product.class, ProductID);
    }   	
    
    public List<Product> getAllProduct() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

    public List<Product> getProductsByCategory(int categoryid){
    	Query q=sessionFactory.getCurrentSession().createQuery("from Product where categoryid=?");
    	q.setInteger(0, categoryid);
    	
    	List<Product> list=q.list();
    	
		return list;
    	
    }


}