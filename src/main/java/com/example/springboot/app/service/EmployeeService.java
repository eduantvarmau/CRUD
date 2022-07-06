package com.example.springboot.app.service;

import java.util.List;
import com.example.springboot.app.model.Employee;


public interface EmployeeService {
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	List<Employee> getAllEmployee();

	Employee getEmployeeById(Integer employeeId);
	void deleteEmployee(Integer id);


}//interface
