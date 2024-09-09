package com.example.service;
import com.example.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Integer> getAllEmployeeIDs();
    Employee getEmployeeById(int empID);
    void updateEmployee(Employee employee);
    void deleteEmployee(int empID);
}