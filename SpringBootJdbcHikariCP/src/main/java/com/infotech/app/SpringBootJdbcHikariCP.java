package com.infotech.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.app.dao.EmployeeDAO;
import com.infotech.app.model.Employee;

@SpringBootApplication
public class SpringBootJdbcHikariCP implements CommandLineRunner{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcHikariCP.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//cerateEmployee();
		getEmployeeById();
		//employeeDAO.updateEmployeeEmailById(3, "kishan.cs2111@gamil.com");
		//employeeDAO.deleteEmployeeById(3);
		
		System.out.println("DataSource==="+dataSource);
	}

	private void getEmployeeById() {
		Employee employee = employeeDAO.getEmployeeById(2);
		System.out.println(employee);
	}

	private void cerateEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Kishan");
		employee.setEmail("kishan.cs2006@gamil.com");
		employee.setSalary(90000.00);
		employeeDAO.createEmployee(employee);
	}
}
