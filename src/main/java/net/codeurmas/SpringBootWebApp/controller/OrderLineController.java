package net.codeurmas.SpringBootWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeurmas.SpringBootWebApp.model.Customer;
import net.codeurmas.SpringBootWebApp.model.OrderLine;
import net.codeurmas.SpringBootWebApp.model.Orders;
import net.codeurmas.SpringBootWebApp.model.Product;
import net.codeurmas.SpringBootWebApp.service.CustomerService;
import net.codeurmas.SpringBootWebApp.service.OrderLineService;
import net.codeurmas.SpringBootWebApp.service.OrderService;
import net.codeurmas.SpringBootWebApp.service.ProductService;

@Controller
public class OrderLineController {
	 //OrderList
	 @Autowired
	 private OrderLineService orderLineService;
	
	 @Autowired
	 private OrderService orderService;
	 
	 @Autowired
	 private ProductService productService;
	
	 @RequestMapping("/list_orderline")
	 public String listOrderLine(Model model) {
	         
		 List<OrderLine> listOrderLines = orderLineService.listAll();
		 model.addAttribute("listOrderLines", listOrderLines);    
	         
	     return "orderline";
	 }
	 @RequestMapping("/neworderline/{id}")
	 public String showNewOrderLinePage(@PathVariable(name = "id") int id,Model model) {
	     //List<Orders> listOrders = orderService.listAll();
	     List<Product> listProducts = productService.listAll();	     
		 OrderLine orderLine = new OrderLine();
		 Orders order = orderService.get(id);
		 System.out.println("showNewOrderLinePage>id of order: " + order.getId());
		 orderLine.setOrder(order);
		 
		 model.addAttribute("orderLine", orderLine);
	     //model.addAttribute("listOrders", listOrders);	     
	     model.addAttribute("listProducts", listProducts);
	     
	     
	     
	     
	    
	     return "new_orderline";
	 }
	 /*
	 @RequestMapping("/editorder/{id}")
	 public String showEditOrderForm(@PathVariable(name = "id") int id, Model model) {
	     Orders order = orderService.get(id);
	     model.addAttribute("order", order); 
	     List<Customer> listCustomers = customerService.listAll();
	     model.addAttribute("listCustomers", listCustomers);
	     return "new_order";       
	 }*/
	 
	 @RequestMapping(value = "/saveorderline", method = RequestMethod.POST)
	 public String saveOrderLine(@ModelAttribute("orderLine") OrderLine orderLine) {
	     orderLineService.save(orderLine);
	      
	     return "redirect:/";
	 }
	 

}
