package com.example.dao;

import com.example.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Integer> getAllEmployeeIDs() {
        String sql = "SELECT empID FROM EmployeeTable";
        return jdbcTemplate.queryForList(sql, Integer.class);
    }

    @Override
    public Employee getEmployeeById(int empID) {
        String sql = "SELECT * FROM EmployeeTable WHERE empID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{empID}, new EmployeeRowMapper());
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE EmployeeTable SET empname = ?, designation = ?, salary = ? WHERE empID = ?";
        jdbcTemplate.update(sql, employee.getEmpName(), employee.getDesignation(), employee.getSalary(), employee.getEmpID());
    }

    @Override
    public void deleteEmployee(int empID) {
        String sql = "DELETE FROM EmployeeTable WHERE empID = ?";
        jdbcTemplate.update(sql, empID);
    }

    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmpID(rs.getInt("empID"));
            employee.setEmpName(rs.getString("empname"));
            employee.setDesignation(rs.getString("designation"));
            employee.setSalary(rs.getDouble("salary"));
            return employee;
        }
    }
}