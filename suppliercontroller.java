package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;




@Controller
public class suppliercontroller {

	@Autowired
	SupplierDAO sd;

	@RequestMapping("/Supplier")
	public String AddCategory(Model m) {

		List<Supplier> List = sd.getAllSupplier();
		m.addAttribute("Supplierlist", List);
		System.out.println(List.size());
		m.addAttribute("object", new Supplier());
		return "Supplier";
	}

	@RequestMapping("/SaveSupplier")
	public String Save(@ModelAttribute("object") Supplier s, Model m) {
		m.addAttribute("object",new Supplier());
		sd.saveSupplier(s);
		List<Supplier> List = sd.getAllSupplier();
		m.addAttribute("Supplierlist", List);
		return "Supplier";
		
		
		
	}
	
	

	@RequestMapping("/DeleteSupplier{Id}")
	public String Delete(@PathVariable("Id") int id, Model m) {

		Supplier cat = new Supplier();
		cat.setId(id);
		sd.deleteSupplier(cat);
		m.addAttribute("object", new Supplier());
		List<Supplier> List = sd.getAllSupplier();
		m.addAttribute("Supplierlist", List);
		return ("Supplier");
	}

	@RequestMapping("/UpdateSupplier{Id}")
	public String Update(@PathVariable("Id") int id, Model m) {

		Supplier c = sd.getSupplier(id);
		m.addAttribute("object", c);
		List<Supplier> List = sd.getAllSupplier();
		m.addAttribute("Supplierlist", List);
		return ("Supplier");
	}
}