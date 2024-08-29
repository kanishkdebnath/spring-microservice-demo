package com.kanishk.department_service.client;

import com.kanishk.department_service.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/department/{id}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable String id);
}
