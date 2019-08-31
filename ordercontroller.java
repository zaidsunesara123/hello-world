package com.niit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDetailsDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetails;
import com.niit.model.Product;

@Controller
public class ordercontroller {
	
	@Autowired
	CartDAO cd;
	
	@Autowired
	ProductDAO pd;
	
	@Autowired
	OrderDetailsDAO odd;
	
	
	@RequestMapping("/ConfirmOrder")
	public String ConfirmOrder(Model m)
	{
		System.out.println("");
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
			int qty;
		List<CartItem> List = cd.getcartByuserName(userName);
		m.addAttribute("CartItemList", List);
		//m.addAttribute("grandTotal",this.grandTotal(List));
	return "ConfirmOrder";
		
	}
	
	@RequestMapping("/PaymentConfirm")
	public String PaymentConfirm(@RequestParam("pmode")String
			pmode,@RequestParam("shipAddr") String shipAddr, Model m) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		
		List<CartItem> List=cd.getcartByuserName(userName);
		
		OrderDetails order= new OrderDetails();
        order.setOrderDate(new Date());	
		order.setShippingAddr(shipAddr);
		order.setTranType(pmode);
		order.setUserName(userName);
		//order.setTotalAmount(this.grandTotal(List));
		odd.confirmOrderDetail(order);
		 
		for (CartItem cartItem : List) {
			cartItem.setPaymentstatus("P");
		}
			
		
		return "Thankyou";
		
	}
	
//	public String  grandTotal(List<CartItem> List){
//	
//	double grandTotal=0.0;
//	for (CartItem cartItem : List) {
//		Product p= pd.getProduct(cartItem.getProductid());
//		grandTotal=grandTotal+(cartItem.getTotal()*(p.getPrice()));
//
//	
//	return "grandTotal";
//
//}
	
	

	}	
	
	
