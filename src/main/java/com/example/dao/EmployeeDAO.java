package com.example.dao;

import com.example.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Integer> getAllEmployeeIDs();
    Employee getEmployeeById(int empID);
    void updateEmployee(Employee employee);
    void deleteEmployee(int empID);
}
