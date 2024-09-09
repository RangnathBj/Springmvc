package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) 
    {
        List<Integer> empIDs = employeeService.getAllEmployeeIDs();
        model.addAttribute("empIDs", empIDs);
        return "employeeList";
    }

    @GetMapping("/{empID}")
    public String getEmployeeDetails(@PathVariable("empID") int empID, Model model) 
    {
        Employee employee = employeeService.getEmployeeById(empID);
        model.addAttribute("employee", employee);
        return "employeeDetails";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("empID") int empID) {
        employeeService.deleteEmployee(empID);
        return "redirect:/employees";
    }
}
