package net.codeurmas.SpringBootWebApp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codeurmas.SpringBootWebApp.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
