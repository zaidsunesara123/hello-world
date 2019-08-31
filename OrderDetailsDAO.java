package com.niit.dao;

import java.util.List;

import com.niit.model.OrderDetails;

public interface OrderDetailsDAO {
	
	public void confirmOrderDetail (OrderDetails orderDetail);
	public void updateOrderDetails (OrderDetails orderDetail);
	public List<OrderDetails> getOrderDetail (String userName);
	
	

}
