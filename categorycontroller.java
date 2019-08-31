package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;

import com.niit.model.Category;

@Controller
public class categorycontroller {

	@Autowired
	CategoryDAO cd;

	@RequestMapping("/Category")
	public String AddCategory(Model m) {

		List<Category> List = cd.getAllCategory();
		m.addAttribute("Categorylist", List);
		System.out.println(List.size());
		m.addAttribute("object", new Category());
		return "Category";
	}
	
	
	@RequestMapping("/Save Category")
	public String Save(@ModelAttribute Category c, Model m) {
		System.out.println("In save category method");
		Category cat = new Category();
		c.setCategoryid(c.getCategoryid());
		c.setName(c.getName());
		c.setDiscription(c.getDiscription());
		cd.saveCategory(c);
		List<Category> List = cd.getAllCategory();
		m.addAttribute("Categorylist", List);
		m.addAttribute("object", new Category());
		return ("Category");

	}

	@RequestMapping("/DeleteCategory{Id}")
	public String Delete(@PathVariable("Id") int id, Model m) {

		Category cat = new Category();
		cat.setCategoryid(id);
		cd.deleteCategory(cat);
		m.addAttribute("object", new Category());
		List<Category> List = cd.getAllCategory();
		m.addAttribute("Productlist", List);
		return ("Category");
	}

	@RequestMapping("/UpdateCategory{Id}")
	public String Update(@PathVariable("Id") int id, Model m) {

		Category c = cd.getCategory(id);
		m.addAttribute("object", c);
		List<Category> List = cd.getAllCategory();
		m.addAttribute("Categorylist", List);
		return ("Category");
	}
	
	}
