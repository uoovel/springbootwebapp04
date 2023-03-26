package net.codeurmas.SpringBootWebApp.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@Length(min=1, max=100, message="{Check name}")
	private String fullname;
	@Column
	private String regCode;
	@Column
	private String email;
	@Column
	private String phone;
	
	
	public String getRegCode() {
		return regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Customer() {
		
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
