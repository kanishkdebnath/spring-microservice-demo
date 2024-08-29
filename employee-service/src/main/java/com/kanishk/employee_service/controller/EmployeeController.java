package com.kanishk.employee_service.controller;

import com.kanishk.employee_service.model.Employee;
import com.kanishk.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("Employee added with details : {}", employee);
        return repository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("All employee details fetched.");
        return repository.fetchAllEmployees();
    }

    @GetMapping("/department/{id}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable String id) {
        log.info("All employees fetched from department ID : {}", id);
        return repository.fetchAllEmployeesByDepartment(id);
    }
}
