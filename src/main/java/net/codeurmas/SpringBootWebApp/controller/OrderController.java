package net.codeurmas.SpringBootWebApp.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeurmas.SpringBootWebApp.model.Customer;
import net.codeurmas.SpringBootWebApp.model.Orders;
import net.codeurmas.SpringBootWebApp.service.CustomerService;
import net.codeurmas.SpringBootWebApp.service.OrderService;

@Controller
public class OrderController {
	 //Order
	 @Autowired
	 private OrderService orderService;	 
	 
	 @Autowired
	 private CustomerService customerService;
	 
	 @RequestMapping("/neworder")
	 public String showNewOrderPage(Model model) {	     
		 
		 Orders order = new Orders();
	     model.addAttribute("order", order);
	     List<Customer> listCustomers = customerService.listAll();
	     model.addAttribute("listCustomers", listCustomers);  	     
	     return "new_order";
	 }
	 @RequestMapping(value = "/saveorder", method = RequestMethod.POST)
	 public String saveOrder(@ModelAttribute("order") Orders order) {
	     orderService.save(order);	      
	     return "redirect:/";
	 }
	 
	 @RequestMapping("/editorder/{id}")
	 public String showEditOrderForm(@PathVariable(name = "id") int id, Model model) {
	     Orders order = orderService.get(id);
	     model.addAttribute("order", order); 
	     List<Customer> listCustomers = customerService.listAll();
	     model.addAttribute("listCustomers", listCustomers);
	     return "new_order";       
	 }
	 
	 @RequestMapping("/deleteorder/{id}")
	 public String deleteOrder(@PathVariable(name = "id") int id) {
	     orderService.delete(id);
	     return "redirect:/";       
	 }
	 
	 /*
	 @RequestMapping("/list_order")
	 public String listOrder(Model model,
			 @Param("keyword") String keyword,
			 @Param("keyCustomer") String keyCustomer) {
		 //System.out.println("OrdersController>listorder>100"); 
		 //Date dkeyword = null;
		 //if( keyword != null) {
		 //	 dkeyword = java.sql.Date.valueOf(keyword);
		 //}		 
		 List<Orders> listOrders = orderService.listAll(keyword, keyCustomer);
		 //System.out.println("OrdersController>listorder>200");
		 model.addAttribute("listOrders", listOrders); 
		 //System.out.println("OrdersController>listorder>300");
		 //search = new Search();
		 model.addAttribute("keyword", keyword);    
	     return "order";
	 }*/

}
