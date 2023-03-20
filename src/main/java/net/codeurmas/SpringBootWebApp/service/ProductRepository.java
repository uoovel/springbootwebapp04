package net.codeurmas.SpringBootWebApp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codeurmas.SpringBootWebApp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
