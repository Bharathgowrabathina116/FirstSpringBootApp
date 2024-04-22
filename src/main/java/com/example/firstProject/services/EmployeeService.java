package com.example.firstProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.firstProject.dto.Employee;
import com.example.firstProject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository emprepo;
	
	public Employee createEmployee(@RequestBody Employee emp) {
		 return emprepo.save(emp);
	}
	
	public ResponseEntity<List<Employee>> fetchEmployees(){
		List<Employee> emplist;
		emplist = emprepo.findAll();
		
		System.out.println("Hello, Service Layer running successfully");
		
		return new ResponseEntity<>(emplist, HttpStatus.OK);
	}
	
	public ResponseEntity<Employee> FetchEmployeeByID(@PathVariable int id){
		Optional<Employee> emp = emprepo.findById(id);
		if (emp.isPresent()) {
			return new ResponseEntity<>(emp.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Employee> UpdateEmployeeByID(@PathVariable int id,@RequestBody Employee newEmp){
		Optional<Employee> oldEmp = emprepo.findById(id);
		
		if(oldEmp.isPresent()) {
			Employee updateEmployee = oldEmp.get();
			updateEmployee.setEmp_name(newEmp.getEmp_name());
			updateEmployee.setSalary(newEmp.getSalary());
			updateEmployee.setAge(newEmp.getAge());
			updateEmployee.setDepartment(newEmp.getDepartment());
			
			Employee empObj = emprepo.save(updateEmployee);
			return new ResponseEntity<>(empObj, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Employee> DeleteEmployeeById(@PathVariable int id){
		emprepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
