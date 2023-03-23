package net.codeurmas.SpringBootWebApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codeurmas.SpringBootWebApp.model.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
