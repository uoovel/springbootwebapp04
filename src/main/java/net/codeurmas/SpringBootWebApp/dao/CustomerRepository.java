package net.codeurmas.SpringBootWebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codeurmas.SpringBootWebApp.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("SELECT c FROM Customer c WHERE c.fullname LIKE %?1%")
	public List<Customer> search(String keyCustomer);

	@Query("SELECT c FROM Customer c WHERE c.fullname LIKE %?1%")
	public Customer getByName(String testCustomerName);
	
}
