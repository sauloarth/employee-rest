package com.sabreit.employeeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sabreit.employeeapi.dao.EmployeeDAO;
import com.sabreit.employeeapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO dao;

	public EmployeeServiceImpl(@Qualifier("employeeJpaDAO")EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		dao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	
}
