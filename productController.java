package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class productController {

	@Autowired
	ProductDAO pd;

	@Autowired
	CategoryDAO cd;

	@Autowired
	SupplierDAO sd;
	
	@RequestMapping("/Product")
	public String AddProduct(Model m) {
		Product p2;
		// p2.setId();
		// p2.setPhone("Oppo");
		// p2.setPrice(70000);
		// p2.setQuantity(3);
		/* pd.saveProduct(p2);8\ */
		List<Category> CategoryList =cd.getAllCategory();
		List<Supplier> SupplierList =sd.getAllSupplier();
			
		List<Product> List = pd.getAllProduct();
		m.addAttribute("Productlist", List);
		m.addAttribute("Categorylist", CategoryList);
		m.addAttribute("Supplierlist", SupplierList);
		
		System.out.println(List.size());
		m.addAttribute("object", new Product());
		return "Product";
	}

	@RequestMapping("/Save Product")
	public String Save(@ModelAttribute Product r, Model m) {
		MultipartFile mf = r.getProductimage();

		pd.saveProduct(r);
		List<Product> List = pd.getAllProduct();
		m.addAttribute("Productlist", List);
		m.addAttribute("object", new Product());
		
		String path="F:\\E-commerce\\E-commerce\\src\\main\\webapp\\resources\\productimage\\"+r.getId()+".jpg";
		
		File file = new File(path);
		
		if (!mf.isEmpty()) {
			try {
				FileOutputStream fos=new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				byte[] bytes= mf.getBytes();
				bos.write(bytes);
				bos.flush();
				bos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("FileEmpty");
			
		}

		return ("Product");

	}

	@RequestMapping("/DeleteProduct{Id}")
	public String Delete(@PathVariable("Id") int id, Model m) {

		Product p = new Product();
		p.setId(id);
		pd.deleteProduct(p);
		m.addAttribute("object", new Product());
		List<Product> List = pd.getAllProduct();
		m.addAttribute("Productlist", List);
		return ("Product");
	}

	@RequestMapping("/UpdateProduct{Id}")
	public String Update(@PathVariable("Id") int id, Model m) {

		Product p = pd.getProduct(id);
		m.addAttribute("object", p);
		List<Product> List = pd.getAllProduct();
		m.addAttribute("Productlist", List);
		return ("Product");
	}

	@RequestMapping("/Getcategory{Id}")
	public String Getcategory(@PathVariable("Id") int id, Model m) {
		List<Product> list = pd.getProductsByCategory(id);
		m.addAttribute("List", list);
		return "Productlist";
	}

	@RequestMapping("/Details{Id}")
	public String GetDetails(@PathVariable("Id") int id, Model m) {
		Product product = pd.getProduct(id);
		m.addAttribute("product", product);
		return "Productdetails";

	}
}