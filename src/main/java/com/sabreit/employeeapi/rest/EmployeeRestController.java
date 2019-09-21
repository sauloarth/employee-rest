package com.sabreit.employeeapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabreit.employeeapi.entity.Employee;
import com.sabreit.employeeapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService service;

	@Autowired
	public EmployeeRestController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		Employee employee = service.findById(id);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee employee) {
		employee.setId(0);
		service.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		
		service.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public Employee deleteById(@PathVariable int id) {
		Employee employee = service.findById(id);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		service.deleteById(employee.getId());
		
		return employee;
		
	}

}
