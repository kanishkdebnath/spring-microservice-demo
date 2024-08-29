package com.kanishk.department_service.repository;

import com.kanishk.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department fetchDepartmentById(String id) {
        return departments.stream()
                .filter(department -> department.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> fetchDepartments() {
        return departments;
    }
}
