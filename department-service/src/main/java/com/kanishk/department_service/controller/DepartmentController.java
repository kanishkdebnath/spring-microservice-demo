package com.kanishk.department_service.controller;

import com.kanishk.department_service.client.EmployeeClient;
import com.kanishk.department_service.model.Department;
import com.kanishk.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        log.info("Department added with details : {}", department);
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartment() {
        log.info("Received all the departments details");
        return repository.fetchDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable String id) {
        log.info("Department received with id : {}", id);
        return repository.fetchDepartmentById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getDepartmentById() {
        log.info("Departments with employee details received");
        List<Department> departments = repository.fetchDepartments();

        departments.forEach(department -> department.setEmployees(employeeClient.getAllEmployeesByDepartment(department.getId())));
        return departments;
    }

}
