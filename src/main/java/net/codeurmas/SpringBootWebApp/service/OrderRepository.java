//codejava.net/frameworks/spring-boot/spring-data-jpa-filter-search-examples

package net.codeurmas.SpringBootWebApp.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codeurmas.SpringBootWebApp.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

	@Query("SELECT o FROM Orders o WHERE o.date LIKE %?1%")
	public List<Orders> search(String keyword);
}
