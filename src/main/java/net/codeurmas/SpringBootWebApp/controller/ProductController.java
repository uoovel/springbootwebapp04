package net.codeurmas.SpringBootWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import net.codeurmas.SpringBootWebApp.model.Product;
import net.codeurmas.SpringBootWebApp.service.ProductService;

@Controller
public class ProductController {
	 //product
	 @Autowired
	 private ProductService service;
	 
	 @RequestMapping("/list_product")
	 public String listProduct(Model model) {
	         
		 List<Product> listProducts = service.listAll();
		 model.addAttribute("listProducts", listProducts);    
	         
	     return "product";
	 }

	 @RequestMapping("/edit/{id}")
	 public String showEditProductForm(@PathVariable(name = "id") int id, Model model) {
	     Product product = service.get(id);
	     model.addAttribute("product", product);
	     
	     
	     return "new_product";       
	 }
	 
	 @RequestMapping("/delete/{id}")
	 public String deleteProduct(@PathVariable(name = "id") int id) {
	     service.delete(id);
	     return "redirect:/";       
	 }
	 
	 @RequestMapping("/new")
	 public String showNewProductPage(Model model) {
	     Product product = new Product();
	     model.addAttribute("product", product);
	      
	     return "new_product";
	 }
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String saveProduct(@Valid @ModelAttribute("product") Product product,
			 BindingResult result) {
		 
	     if(result.hasErrors()) {
	    	 return "new_product";
	     }
		 
		 service.save(product);
	      
	     return "redirect:/";
	 }
}
