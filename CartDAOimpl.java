package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartItem;


@Repository("cartDAOimpl")
@Transactional
public class CartDAOimpl implements CartDAO {
	
	@Autowired
	SessionFactory sf;

	public void saveCart(CartItem cart) {
		sf.getCurrentSession().saveOrUpdate(cart);
	}

	public void deleteCart(CartItem cart) {
		sf.getCurrentSession().delete(cart);
	}

	public CartItem getCart(int id) {
		
		return sf.getCurrentSession().get(CartItem.class, id);
	}

	public List<CartItem> getAll() {
		Query qry= sf.getCurrentSession().createQuery("from CartItem");
		List<CartItem> list=qry.list();	
				
				return list;
	}

	public List<CartItem> getcartByuserName(String userName) {
		Query qry=sf.getCurrentSession().createQuery("from CartItem where userName=?");
		qry.setString(0, userName);
		List<CartItem> list=qry.list();
		
		return list;
	}
}
