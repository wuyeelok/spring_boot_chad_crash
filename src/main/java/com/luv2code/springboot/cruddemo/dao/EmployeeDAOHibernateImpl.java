package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.luv2code.springboot.cruddemo.entity.Employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // Define field for entitymanager
    private EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // Create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee order by id", Employee.class);

        // Excecute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // Get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        // return the results
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // Create(if id is zero) or Update employee
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }

}
