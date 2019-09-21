package com.sabreit.employeeapi.dao;

import java.util.List;

import com.sabreit.employeeapi.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}
