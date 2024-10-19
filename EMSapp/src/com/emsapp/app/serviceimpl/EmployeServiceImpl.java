package com.emsapp.app.serviceimpl;

import java.util.List;
import java.util.Scanner;

import com.emsapp.app.daio.EmployeeDaio;
import com.emsapp.app.daioimpl.EmpoloyeeDaioImpl;
import com.emsapp.app.model.Employee;
import com.emsapp.app.servicei.EmployeeServiceI;

public class EmployeServiceImpl implements EmployeeServiceI {
	Scanner sc = new Scanner(System.in);
	EmployeeDaio eido = new EmpoloyeeDaioImpl();

	@Override
	public void createTable(String s) {
	 eido.createTable(s);
	}

	@Override
	public void addEmployee(Employee e) {
		eido.addEmployee(e);

	}

	@Override
	public List<Employee> viewEmployee() {
		List<Employee> list = eido.viewEmployee();
		return list;
	}

	@Override
	public List<Employee> updateEmployee(Employee e) {
		List<Employee> list=eido.updateEmployee(e);
		 
		return list;
	}

	@Override
	public List<Employee> deleteEmployee(int id) {
		List<Employee> list= eido.deleteEmployee(id);
		return list;
	}

	@Override
	public void dropEmployeeTable(String s) {
	 eido.dropEmployeeTable(s);
		
	}

	@Override
	public Employee loginByIdName(int eid, String name) {
		 Employee e=eido.loginByIdName(eid, name);
		return e;
	}
  
}
