package com.example.firstProject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstProject.dto.Employee;
import com.example.firstProject.repository.EmployeeRepository;
import com.example.firstProject.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")	
public class EmployeeController {
	@Autowired
	EmployeeRepository emprepo;

	@Autowired
	EmployeeService empservice;
	
	// Create an Employee
	@PostMapping
	public Employee createEmployee(@RequestBody Employee emp) {
		return empservice.createEmployee(emp);
	}
	
	// Get all the Employees
	@GetMapping
	public ResponseEntity<List<Employee>> fetchEmployees() {
		return empservice.fetchEmployees();
	}
	
	// Fetch an employee by ID
	@GetMapping("/{id}")
	public ResponseEntity<Employee> FetchEmployeeByID(@PathVariable int id){
		return empservice.FetchEmployeeByID(id);
	}
	
	// Update Employee details by ID
	@PutMapping("/{id}")
	public ResponseEntity<Employee> UpdateEmployeeByID(@PathVariable int id,@RequestBody Employee newEmp){
		return empservice.UpdateEmployeeByID(id, newEmp);
	}
	
	// Delete employee record by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> DeleteEmployeeById(@PathVariable int id){
		return empservice.DeleteEmployeeById(id);
	}
}
