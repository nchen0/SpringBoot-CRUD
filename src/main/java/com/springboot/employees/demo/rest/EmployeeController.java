package com.springboot.employees.demo.rest;

import com.springboot.employees.demo.entity.Employee;
import com.springboot.employees.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    // Quick and dirty: inject employee dao
    private EmployeeService employeeService;

    // Expose "/employees" endpoint to return list of employees
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployee(@PathVariable int id) {
        Employee theEmployee = employeeService.findById(id);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found for: " + id);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public void saveEmployee(@RequestBody Employee newEmployee) {
        // In case they pass an id in JSON, we want to set the id to 0
        newEmployee.setId(0);
        if (newEmployee.getFirstName() == null || newEmployee.getLastName() == null) {
            throw new RuntimeException("Fields missing");
        }
        employeeService.saveEmployee(newEmployee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee existingEmployee) {
        if (employeeService.findById(id) == null) {
            throw new RuntimeException("Id not found: " + id);
        }
        employeeService.saveEmployee(existingEmployee);
    }


    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        if (employeeService.findById(id) == null) {
            throw new RuntimeException("Id not found: " + id);
        }
        employeeService.deleteById(id);
    }
}
