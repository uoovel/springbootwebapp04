package net.codeurmas.SpringBootWebApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeurmas.model.Contact;

import net.codeurmas.service.ContactBusiness;

@Controller
public class AppController {
	 @RequestMapping("/list_contact")
	    public String listContact(Model model) {
	         
	        ContactBusiness business = new ContactBusiness();
	        List<Contact> contactList = business.getContactList();
	         
	        model.addAttribute("contacts", contactList);       
	         
	        return "contact";
	    }
	 
	 @Autowired
	 private ProductService service;
	 
	 @RequestMapping("/list_product")
	 public String listProduct(Model model) {
	         
		 List<Product> listProducts = service.listAll();
		 model.addAttribute("listProducts", listProducts);    
	         
	     return "product";
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
	 public String saveProduct(@ModelAttribute("product") Product product) {
	     service.save(product);
	      
	     return "redirect:/";
	 }
}
