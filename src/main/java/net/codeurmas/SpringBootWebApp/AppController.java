package net.codeurmas.SpringBootWebApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeurmas.SpringBootWebApp.model.Customer;
import net.codeurmas.SpringBootWebApp.model.Orders;
import net.codeurmas.SpringBootWebApp.model.Product;
import net.codeurmas.SpringBootWebApp.service.CustomerService;
import net.codeurmas.SpringBootWebApp.service.OrderService;
import net.codeurmas.SpringBootWebApp.service.ProductService;


@Controller
public class AppController {

	 //product
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
	 //Order
	 @Autowired
	 private OrderService orderService;
	
	 @RequestMapping("/list_order")
	 public String listOrder(Model model) {
	         
		 List<Orders> listOrders = orderService.listAll();
		 model.addAttribute("listOrders", listOrders);    
	         
	     return "order";
	 }
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
	 public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	     customerService.save(customer);
	      
	     return "redirect:/";
	 }
}
