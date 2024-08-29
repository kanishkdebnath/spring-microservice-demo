package com.kanishk.employee_service.repository;

import com.kanishk.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> fetchAllEmployees() {
        return employees;
    }

    public List<Employee> fetchAllEmployeesByDepartment(String departmentID) {
        return employees.stream()
                .filter(employee -> employee.departmentId().equalsIgnoreCase(departmentID))
                .toList();
    }
}
