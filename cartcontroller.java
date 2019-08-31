package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.RegistrationDAO;
import com.niit.model.CartItem;
import com.niit.model.Product;


@Controller
public class cartcontroller {
	
	@Autowired	
	ProductDAO pd;

	@Autowired
	CartDAO cd;

	@Autowired
	RegistrationDAO rd;


	@RequestMapping("/ShowCart")
	public String Cart(Model m) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		
		List<CartItem> list = cd.getcartByuserName(userName);	
		for(CartItem l:list)
		{
			System.out.println("cartitem:-"+l.getProductname());
		}
		m.addAttribute("CartItemList", list);
		m.addAttribute("grandTotal", this.grandTotal(list));
		return ("ShowCart");
	}
	
	
	@RequestMapping("/saveCart{id}")
	public String addCart(Model m, @PathVariable("id") int pdId, @RequestParam("quantity") int quantity) {
		
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		
		List<CartItem> list = cd.getcartByuserName(userName);

		Product p = new Product();
		p = pd.getProduct(pdId);
		
		CartItem c = new CartItem();
		c.setPrice(p.getPrice());
		c.setProductname(p.getPhone());
		c.setProductid(p.getId());
		c.setTotal(p.getPrice() * quantity);
		c.setQuantity(quantity);
		c.setPaymentstatus("NP");
		c.setGrandTotal(this.grandTotal(list));
		c.setUsername(userName);
		
		cd.saveCart(c);

		
		m.addAttribute("CartItemList", list);
		m.addAttribute("grandTotal", this.grandTotal(list));

		return "ShowCart";
		
		
	}

	
	
	@RequestMapping("/RemoveProduct{id}")
	public String removeProduct(Model m, @PathVariable("id") int pid) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();

		CartItem ct = cd.getCart(pid);
		cd.deleteCart(ct);

		List<CartItem> List = cd.getcartByuserName(userName);
		m.addAttribute("CartItemList", List);
		m.addAttribute("grandTotal", this.grandTotal(List));

		return ("ShowCart");
	}

	
	
	
	public int grandTotal(List<CartItem> List) {

		int grandTotal = 0;
		for (CartItem cartItem : List) {

			Product product = pd.getProduct(cartItem.getProductid());
			grandTotal = grandTotal + (cartItem.getQuantity() * (product.getPrice()));
		}

		return grandTotal;
	}
}
