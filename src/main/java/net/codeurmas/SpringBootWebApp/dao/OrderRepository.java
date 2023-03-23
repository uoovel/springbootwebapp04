package net.codeurmas.SpringBootWebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codeurmas.SpringBootWebApp.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

	@Query("SELECT o FROM Orders o WHERE o.datestring LIKE %?1%")
	public List<Orders> search(String keyword);
}

