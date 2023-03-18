package net.codeurmas.SpringBootWebApp;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {

}
