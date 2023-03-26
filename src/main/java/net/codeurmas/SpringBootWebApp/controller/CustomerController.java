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
import net.codeurmas.SpringBootWebApp.model.Customer;
import net.codeurmas.SpringBootWebApp.model.Product;
import net.codeurmas.SpringBootWebApp.service.CustomerService;

@Controller
public class CustomerController {

	 //Customer
	 @Autowired
	 private CustomerService customerService;
	 @RequestMapping("/list_customer")
	 public String listCustomer(Model model) {
	         
		 List<Customer> listCustomers = customerService.listAll();
		 model.addAttribute("listCustomers", listCustomers);    
	         
	     return "customer";
	 }
	 @RequestMapping("/newcustomer")
	 public String showNewCustomerPage(Model model) {
	     Customer customer = new Customer();
	     model.addAttribute("customer", customer);
	      
	     return "new_customer";
	 }
	 @RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
	 public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
	     if(result.hasErrors()) {
	    	 return "new_customer";
	     }
		 
		 customerService.save(customer);
	      
	     return "redirect:/";
	 }
	 
	 @RequestMapping("/editcustomer/{id}")
	 public String showEditCustomerForm(@PathVariable(name = "id") int id, Model model) {
	     Customer customer = customerService.get(id);
	     model.addAttribute("customer", customer); 
	     return "new_customer";       
	 }
	 
	 @RequestMapping("/deletecustomer/{id}")
	 public String deleteCustomer(@PathVariable(name = "id") int id) {
	     customerService.delete(id);
	     return "redirect:/";       
	 }
}
