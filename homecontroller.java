package com.niit.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CategoryDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Controller
public class homecontroller {
	@Autowired
	CategoryDAO cd;
	
	@Autowired
	SupplierDAO sd;
	
	public homecontroller() {
		System.out.println("this is it ");
	}

	@RequestMapping("/Login")
	public String login()
	{
		return("Login");
		
	}
	
	@RequestMapping("/Welcome")
	public String Welcome(HttpSession s)
	{
		List<Category> List = cd.getAllCategory();
		s.setAttribute("Categorylist", List);
		
		List<Supplier> list = sd.getAllSupplier();
		s.setAttribute("Supplierlist", list);
		
		return("Home");
		
	}
	
	
	@RequestMapping("/About Page")
	public String About()
	{
		return("About");
		
	}
	@RequestMapping("/Contact Page")
	public String Contact()
	{
		return("Contact");
		
	}
	
	@RequestMapping("/Home")
	public String Home()
	{
		return("Home");
	}
	
}



