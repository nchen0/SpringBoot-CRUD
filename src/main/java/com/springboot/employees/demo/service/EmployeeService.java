package com.springboot.employees.demo.service;

import com.springboot.employees.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void saveEmployee(Employee theEmployee);
    public void deleteById(int theId);
}
