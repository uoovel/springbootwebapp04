package net.codeurmas.SpringBootWebApp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codeurmas.SpringBootWebApp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
