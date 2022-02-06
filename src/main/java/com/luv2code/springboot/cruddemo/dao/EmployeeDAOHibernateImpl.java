package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.luv2code.springboot.cruddemo.entity.Employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public List<Employee> findAll() {

        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);

        // Create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        // Excecute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

}
