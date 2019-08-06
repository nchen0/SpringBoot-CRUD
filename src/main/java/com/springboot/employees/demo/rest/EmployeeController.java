package com.springboot.employees.demo.rest;

import com.springboot.employees.demo.dao.EmployeeDAO;
import com.springboot.employees.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    // Quick and dirty: inject employee dao
    private EmployeeDAO employeeDAO;

    // Expose "/employees" endpoint to return list of employees
    @Autowired
    public EmployeeController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
