package com.springboot.employees.dao;

import com.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
