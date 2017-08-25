package com.infotech.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infotech.app.dao.EmployeeDAO;
import com.infotech.app.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createEmployee(Employee employee) {
		String CREATE_EMPLOYEE_SQL = "INSERT INTO employee_table(employee_name,email,salary) VALUES(?,?,?)";
		int update = jdbcTemplate.update(CREATE_EMPLOYEE_SQL, employee.getEmployeeName(),employee.getEmail(),employee.getSalary());
		
		if(update == 1){
			System.out.println("Employee is created..");
		}
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		String GET_EMPLOYEE_SQL="SELECT *FROM employee_table WHERE employee_id=?";
		Employee employee = jdbcTemplate.queryForObject(GET_EMPLOYEE_SQL, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	@Override
	public void updateEmployeeEmailById(Integer employeeId, String newEmail) {
		String UPDATE_EMPLOYEE_SQL = "UPDATE employee_table set email=? WHERE employee_id=?";
		int update = jdbcTemplate.update(UPDATE_EMPLOYEE_SQL, newEmail,employeeId);
		if(update == 1){
			System.out.println("Employee Email is Updated....");
		}
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		String DELETE_EMPLOYEE_SQL = "DELETE FROM employee_table WHERE employee_id=?";
		int update = jdbcTemplate.update(DELETE_EMPLOYEE_SQL,employeeId);
		if(update == 1){
			System.out.println("Employee is Deleted......");
		}
	}

}
