package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.entity.Address;
import com.employee.entity.Emergency;
import com.employee.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String addEmployee(Employee employee) {
		
		try {
			Employee savedEmployee = this.employeeRepository.save(employee);
			if(savedEmployee!=null) {
				return "Employee Saved Successfully";			
			}
			else
				throw new Exception();
		}catch(Exception e) {
			return "Error!! Please Try Again Later";
		}
		
	}
	
	public List<Employee> getEmployeeList(String limit) {
		
		if(limit.equals("ALL"))
			return this.employeeRepository.findAll();
		PageRequest page = PageRequest.of(0, Integer.parseInt(limit));		
		Page<Employee> employees = this.employeeRepository.findAll(page);
		List<Employee> content = employees.getContent();
		return content;
		
	}
	
	public Employee getEmployee(int id) {
		
		return this.employeeRepository.findById(id).get();
		
	}
	
	public String updateEmployee(int id, Employee employee) {
		
		try {
			Employee employee1 = getEmployee(id);		
			employee1.setName(employee.getName());
			employee1.setTitle(employee.getTitle());
			employee1.setPhone(employee.getPhone());
			employee1.setEmail(employee.getEmail());
			Address address=employee1.getAddress();
			address.setAddress(employee.getAddress().getAddress());
			address.setCity(employee.getAddress().getCity());
			address.setState(employee.getAddress().getState());
			employee1.setAddress(address);
			Emergency emergency=employee1.getEmergency();
			emergency.setEmergencyName(employee.getEmergency().getEmergencyName());
			emergency.setEmergencyPhone(employee.getEmergency().getEmergencyPhone());
			emergency.setRelationship(employee.getEmergency().getRelationship());
			employee1.setEmergency(emergency);
			Employee savedEmployee = this.employeeRepository.save(employee1);
			if(savedEmployee!=null) {
				return "Employee Updated Successfully";			
			}
			else
				throw new Exception();
		}catch(Exception e){
			return "Error!! Please Try Again Later";
		}
		
	}
	
	public String deleteEmployee(int id) {
		
		try {
			this.employeeRepository.deleteById(id);
			return "Employee Deleted Successfully";
		}catch(Exception e) {
			return "Error!! Please Try Again Later";
		}
		
	}
	
}
