package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public String addEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
			
		String errors="";
		if(result.hasErrors()) {			
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error:allErrors) {
				errors=errors+error.getDefaultMessage()+"\n";
			}			
			return errors.substring(0,errors.length()-1);
		}
		return this.employeeService.addEmployee(employee);
		
	}
	
	@GetMapping("/list/{limit}")
	public List<Employee> getEmployeeList(@PathVariable("limit") String limit) {
				
		return this.employeeService.getEmployeeList(limit);		
		
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
				
		return this.employeeService.getEmployee(id);		
		
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable("id") int id, @Valid @RequestBody Employee employee, BindingResult result) {
			
		String errors="";
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error:allErrors) {
				errors=errors+error.getDefaultMessage()+"\n";
			}			
			return errors.substring(0,errors.length()-1);
		}
		return this.employeeService.updateEmployee(id, employee);		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
				
		return this.employeeService.deleteEmployee(id);		
		
	}
	
}
