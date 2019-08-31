package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;
@Transactional
@Repository
public class SupplierDAOimpl implements SupplierDAO {

	

	
			@Autowired
			SessionFactory sessionFactory;
			public void saveSupplier(Supplier supplier) {
				
				sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			}
			
			public void deleteSupplier(Supplier supplier) {
			
				sessionFactory.getCurrentSession().delete(supplier);
			}

		    public void editSupplier(Supplier supplier)
		    {
		    	sessionFactory.getCurrentSession().update(supplier);
		    }
		    
		    public Supplier getSupplier(int supplierID)
		    {
		    	
		    	return sessionFactory.getCurrentSession().get(Supplier.class, supplierID);
		    }   	
		    
		    public List<Supplier> getAllSupplier() {
				return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			}

		}



