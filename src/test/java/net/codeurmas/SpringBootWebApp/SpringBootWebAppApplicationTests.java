package net.codeurmas.SpringBootWebApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.awt.PageAttributes.MediaType;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.codeurmas.SpringBootWebApp.dao.CustomerRepository;
import net.codeurmas.SpringBootWebApp.model.Customer;
import net.codeurmas.SpringBootWebApp.model.Orders;
import net.codeurmas.SpringBootWebApp.service.CustomerService;
import net.codeurmas.SpringBootWebApp.service.OrderService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootWebAppApplicationTests {
	@Test
	public void contextLoads() {
	}

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
    private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	private MockMvc mockMVC;
	
	@BeforeEach
	public void setup() throws Exception{
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	//@Test
	//public void createUserTest() {
	//	mockMVC.perform(post("/").content(MediaType.))
	//}
	
	@Test
	void shouldWelcome() {
		AppController appController = new AppController();
		assertEquals("Welcome", appController.welcome());
	}
	
	@Test
	void shouldGiveListOrder() {
				
		Customer customer = new Customer();
		String time = LocalDateTime.now().toString();
		String testCustomerName = "UnitTestCustomer1x1x" + time;
		customer.setFullname(testCustomerName);
		customerService.save(customer);
		Customer customerCreated = customerService.getCustomerByName(testCustomerName);
		System.out.println("shouldGiveListOrder>100: " + customerCreated.getFullname());
		Orders order = new Orders();
		order.setCustomer(customerCreated);
		orderService.save(order);
		List<Orders> orderListAfterAdd = orderService.listAll(null, testCustomerName, null);
		Orders orderCheckable = orderListAfterAdd.get(0);
		System.out.println("shouldGiveListOrder>200: " + orderCheckable.getCustomer().getFullname());
		//order.setCustomer(null);		
	}
	
	@Test
	void shouldDeleteOrder() {
		String randDate = LocalDateTime.now().toString();
		Orders order = new Orders();
		order.setDatestring(randDate);
		orderService.save(order);
		Orders orderCreated = orderService.getOrderByOrderDate(randDate);
		Long orderId = orderCreated.getId();
		orderService.delete(orderId);
		Orders orderNoExist = new Orders();
		try {
			orderNoExist = orderService.get(orderId);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(orderNoExist.getDatestring());
	}
	
}
