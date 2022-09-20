package com.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "Enter Employee Address")
	private String address;
	
	@NotNull(message = "Enter Employee City")
	private String city;
	
	@NotNull(message = "Enter Employee State")
	private String state;
	
	@JsonBackReference
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
