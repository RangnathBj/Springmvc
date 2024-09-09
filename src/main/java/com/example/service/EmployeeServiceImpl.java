package com.example.service;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Integer> getAllEmployeeIDs() {
        return employeeDAO.getAllEmployeeIDs();
    }

    @Override
    public Employee getEmployeeById(int empID) {
        return employeeDAO.getEmployeeById(empID);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int empID) {
        employeeDAO.deleteEmployee(empID);
    }
}
