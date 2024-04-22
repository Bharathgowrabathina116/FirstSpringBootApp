package com.example.firstProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstProject.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
