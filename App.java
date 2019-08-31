package com.niit.Ecommercebackend;

import java.util.List;

import javax.naming.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DbConfiguration;
import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOimpl;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World !" );
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfiguration.class);
//        ProductDAO productDao = (ProductDAO) applicationContext.getBean("productDAOimpl");
//        
//        Product p = new Product();
//        p.setId(103);
//        p.setPhone("Samsung");
//        p.setPrice(10000);
//        p.setQuantity(1);
//        
//        Product p1 = new Product();
//        p1.setId(104);
//        p1.setPhone("Apple");
//        p1.setPrice(60000);
//        p1.setQuantity(2);
//        
//        Product p2 = new Product();
//        p2.setId(105);
//        p2.setPhone("Oppo");
//        p2.setPrice(15000);
//        p2.setQuantity(3);
//        
//        productDao.saveProduct(p);
//        productDao.saveProduct(p1);
//        productDao.saveProduct(p2);
//        
// 

    	CategoryDAO cd=new CategoryDAOimpl();
    	List<Category> categoryList=cd.getAllCategory();
    	for(Category c:categoryList)
    	{
    		System.out.println(c.getCategoryid());
    	}
    }
}
