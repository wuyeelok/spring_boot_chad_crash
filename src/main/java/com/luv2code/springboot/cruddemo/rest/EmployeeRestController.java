package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // Quick and dirty inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    // expose "/employees" and return list of employess
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

}
