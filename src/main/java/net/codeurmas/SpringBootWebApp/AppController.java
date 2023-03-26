package net.codeurmas.SpringBootWebApp;

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
import net.codeurmas.SpringBootWebApp.model.Product;
import net.codeurmas.SpringBootWebApp.service.CustomerService;
import net.codeurmas.SpringBootWebApp.service.OrderService;
import net.codeurmas.SpringBootWebApp.service.ProductService;


@Controller
public class AppController {

	
	 @Autowired
	 private OrderService orderService;
	 
	 @RequestMapping("/")
	 public String listOrder(Model model,
			 @Param("keyword") String keyword,
			 @Param("keyCustomer") String keyCustomer,
			 @Param("keyProduct") String keyProduct) {
		 
		 List<Orders> listOrders = orderService.listAll(keyword, keyCustomer, keyProduct);
		 model.addAttribute("listOrders", listOrders); 
		 model.addAttribute("keyword", keyword); 
		 model.addAttribute("keyCustomer", keyCustomer);
		 model.addAttribute("keyProduct", keyProduct);
	     return "frontpage";
	 }	 
	 
	 public String welcome() {
		 
		 return "Welcome";
	 }
	 
}
