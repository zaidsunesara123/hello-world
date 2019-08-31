package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.OrderDetails;

@Repository("OrderDetailsDAOimpl")
@Transactional
public class OrderDetailsDAOimpl implements OrderDetailsDAO {
	
	@Autowired
	SessionFactory sf;
	

	public void confirmOrderDetail(OrderDetails orderDetail) {
		
		sf.getCurrentSession().saveOrUpdate(orderDetail);
	}

	public void updateOrderDetails(OrderDetails orderDetail) {
		
		sf.getCurrentSession().update(orderDetail);
	}

	public List<OrderDetails> getOrderDetail(String userName) {
		
		Query query=sf.getCurrentSession().createQuery("from OrderDetails where userName=?");
		query.setString(0, userName);
		List <OrderDetails> list=query.list();
		
		
		
		return list;
	}
	
	

}
