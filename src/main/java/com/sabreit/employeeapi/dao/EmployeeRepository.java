package com.sabreit.employeeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabreit.employeeapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
