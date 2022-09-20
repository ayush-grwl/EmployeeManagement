package com.employee.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Page<Employee> findAll(Pageable pageable);
	
}
