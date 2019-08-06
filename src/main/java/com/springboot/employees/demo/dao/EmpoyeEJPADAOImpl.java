package com.springboot.employees.demo.dao;

import com.springboot.employees.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmpoyeEJPADAOImpl implements EmployeeDAO {

    public EntityManager entityManger;

    @Autowired
    public EmpoyeEJPADAOImpl(EntityManager theEntityManager) {
        entityManger = theEntityManager;
    }

    public List<Employee> findAll() {
        // Create a query
        Query theQuery = entityManger.createQuery("from Employee");

        // Execute query and get results list
        List<Employee> employee = theQuery.getResultList();

        // Return the results
        return employee;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManger.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        Employee dbEmployee = entityManger.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query theQuery = entityManger.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);
        theQuery.executeUpdate();
    }
}
