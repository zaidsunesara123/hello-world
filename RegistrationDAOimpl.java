package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;


@Transactional
@Repository
public class RegistrationDAOimpl implements RegistrationDAO {
	@Autowired
	
	SessionFactory sessionFactory;
	
	public void saveUser(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		
		
	}

	
}
