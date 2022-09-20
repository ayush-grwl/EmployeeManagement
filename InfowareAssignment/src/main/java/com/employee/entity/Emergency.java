package com.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Emergency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String emergencyName;
	
	private String emergencyPhone;
	
	private String relationship;
	
	@JsonBackReference
	@OneToOne(mappedBy = "emergency", cascade = CascadeType.ALL)
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
