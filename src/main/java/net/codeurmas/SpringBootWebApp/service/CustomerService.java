package net.codeurmas.SpringBootWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codeurmas.SpringBootWebApp.dao.CustomerRepository;
import net.codeurmas.SpringBootWebApp.model.Customer;

@Service
@Transactional
public class CustomerService {
	   
	   @Autowired
	    private CustomerRepository repo;
	     
	    public List<Customer> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Customer customer) {
	        repo.save(customer);
	    }
	     
	    public Customer get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
	    
}
