package com.springboot.employees.demo.dao;

import com.springboot.employees.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void saveEmployee(Employee theEmployee);
    public void deleteById(int id);
}
