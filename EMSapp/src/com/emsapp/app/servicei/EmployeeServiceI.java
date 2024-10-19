package com.emsapp.app.servicei;

import java.util.List;

import com.emsapp.app.model.Employee;

public interface EmployeeServiceI {

	public void createTable(String s);

	public void dropEmployeeTable(String s);

	public void addEmployee(Employee e);

	public List<Employee> viewEmployee();

	public List<Employee> updateEmployee(Employee e);

	public List<Employee> deleteEmployee(int id);
	
	public Employee loginByIdName(int eid,String name);
}
