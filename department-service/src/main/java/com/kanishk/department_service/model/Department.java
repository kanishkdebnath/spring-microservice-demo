package com.kanishk.department_service.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Department {
    private String id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
}
