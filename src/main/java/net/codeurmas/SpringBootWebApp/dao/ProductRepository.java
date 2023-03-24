package net.codeurmas.SpringBootWebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import net.codeurmas.SpringBootWebApp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
	List<Product> search(String keyProduct);

}
