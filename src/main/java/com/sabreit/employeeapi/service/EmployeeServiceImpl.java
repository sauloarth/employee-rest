package com.sabreit.employeeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sabreit.employeeapi.dao.EmployeeRepository;
import com.sabreit.employeeapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository dao;

	public EmployeeServiceImpl(EmployeeRepository dao) {
		this.dao = dao;
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = dao.findById(id);
		
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		dao.save(employee);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	
}
