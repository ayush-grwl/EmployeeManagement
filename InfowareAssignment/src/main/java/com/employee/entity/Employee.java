package com.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "Enter Employee Name")
	private String name;
	
	@NotNull(message = "Enter Employee Title")
	private String title;
	
	@NotNull(message = "Enter Employee Phone")
	private String phone;
	
	@NotNull(message = "Enter Employee Email")
	@Email(message = "Enter Valid Email Address")
	private String email;
	
	@JsonManagedReference
	@NotNull(message = "Enter Employee Address")
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	private Emergency emergency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Emergency getEmergency() {
		return emergency;
	}

	public void setEmergency(Emergency emergency) {
		this.emergency = emergency;
	}
	
}
