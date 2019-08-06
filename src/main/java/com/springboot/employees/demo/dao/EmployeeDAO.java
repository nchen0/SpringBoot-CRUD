package com.springboot.employees.demo.dao;

import com.springboot.employees.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
