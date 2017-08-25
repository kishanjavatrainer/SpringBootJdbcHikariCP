package com.infotech.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.infotech.app.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("employee_id"));
		employee.setEmployeeName(rs.getString("employee_name"));
		employee.setEmail(rs.getString("email"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}
}
