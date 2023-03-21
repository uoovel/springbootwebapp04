package net.codeurmas.SpringBootWebApp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String date;
	
	@OneToMany(mappedBy = "order")
	private List<OrderLine> listOrderLines = new ArrayList<>();
	
	public List<OrderLine> getListOrderLines() {
		return listOrderLines;
	}
	public void setListOrderLines(List<OrderLine> listOrderLines) {
		this.listOrderLines = listOrderLines;
	}
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Orders() {
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
		return id;
	}
}
