package net.codeurmas.SpringBootWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codeurmas.SpringBootWebApp.model.Orders;

@Service
@Transactional
public class OrderService {
	   @Autowired
	    private OrderRepository repo;
	     
	    public List<Orders> listAll(String keyword) {
	    	if(keyword != null) {
	    		return repo.search(keyword);
	    	}
	        return repo.findAll();
	    }
	     
	    public void save(Orders order) {
	        repo.save(order);
	    }
	     
	    public Orders get(long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        repo.deleteById(id);
	    }
}
