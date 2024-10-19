package com.emsapp.app.client;

import java.util.List;
import java.util.Scanner;

import com.emsapp.app.model.Employee;
import com.emsapp.app.servicei.EmployeeServiceI;
import com.emsapp.app.serviceimpl.EmployeServiceImpl;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeServiceI empl = new EmployeServiceImpl();
		while (true) {
			System.out.println("***********EMSAPP**************");
			System.out.println(
					"0.Login :\n"
					+ "1.Add Employee \n" + "2.View Employee \n" + "3.Update Employee \n" + "4.Remove Employee \n"
							+ "5.Create Employee Table \n" + "6.Drop Employee Table \n"
									+ "7.Sort Employee Object \n" + "Enter Your Choice : ");
			int ch = sc.nextInt();
			if(ch==0) {
				Employee e=new Employee();
				System.out.println("Enter the Eid :");
				int id=sc.nextInt();
				 
				System.out.println("Enter the Name :");
				 String name=sc.next();
				
				Employee e1=empl.loginByIdName(id,name );
				 
					if(e1!=null) {
						System.out.printf("| %-15s | %-19s | %-15.2f | %-19s |%n", e.getEid(), e.getName(), e.getSalary(),
								e.getEmail());
					}
					else {
						System.out.println("Invalid Credential");
					}
			}
			 
			else if (ch == 1) {
				Employee emp = new Employee();
				System.out.println("Enter id :");
				emp.setEid(sc.nextInt());

				System.out.println("Enter Name:");
				emp.setName(sc.next());

				System.out.println("Enter Salary:");
				emp.setSalary(sc.nextDouble());

				System.out.println("Enter Email:");
				emp.setEmail(sc.next());
				empl.addEmployee(emp);
			}

			else if (ch == 2) {
				List<Employee> list=empl.viewEmployee();
				
				System.out.println("+-----------------+---------------------+-----------------+---------------------+");
				System.err.print("| Employee ID     | Name                | Salary          | Email               |\n");
				System.out.println("+-----------------+---------------------+-----------------+---------------------+");

				for (Employee e : list) {
					// Print table header
					System.out.printf("| %-15s | %-19s | %-15.2f | %-19s |%n", e.getEid(), e.getName(), e.getSalary(),
							e.getEmail());
					System.out.printf("+-----------------+---------------------+-----------------+---------------------+%n");

				}
				
				
			} else if (ch == 3) {
				Employee emp=new Employee();
				System.out.println("Enter Name:");
				emp.setName(sc.next());

				System.out.println("Enter Salary:");
				emp.setSalary(sc.nextDouble());
				System.out.println("Enter Email:");
				emp.setEmail(sc.next());
				System.out.println("Enter the id of Employee that you want to Upadate..");
				  emp.setEid(sc.nextInt());

				List<Employee> list=empl.updateEmployee(emp);
				System.out.println("+-----------------+---------------------+-----------------+---------------------+");
				System.err.print("| Employee ID     | Name                | Salary          | Email               |\n");
				System.out.println("+-----------------+---------------------+-----------------+---------------------+");

				for (Employee e : list) {
				 
					System.out.printf("| %-15s | %-19s | %-15.2f | %-19s |%n", e.getEid(), e.getName(), e.getSalary(),
							e.getEmail());
					System.out.printf("+-----------------+---------------------+-----------------+---------------------+%n");

				}
			 
			} else if(ch==4) {
				
				System.out.println("Enter the Employee ID that you want to delete...");
				int ch1=sc.nextInt();
				List<Employee> list=empl.deleteEmployee(ch1);
				
				System.out.println("+-----------------+---------------------+-----------------+---------------------+");
				System.err.print("| Employee ID     | Name                | Salary          | Email               |\n");
				System.out.println("+-----------------+---------------------+-----------------+---------------------+");

				for (Employee e : list) {
					// Print table header
					System.out.printf("| %-15s | %-19s | %-15.2f | %-19s |%n", e.getEid(), e.getName(), e.getSalary(),
							e.getEmail());
					System.out.printf("+-----------------+---------------------+-----------------+---------------------+%n");

				}
				
				
			}
			else if(ch==5) {
				System.out.println("Enter the name of Table ");
				empl.createTable(sc.next());
			}
			else if(ch==6) {
				System.out.println("Enter the name of table ");
			String s2=sc.next();
			empl.dropEmployeeTable(s2);
			}
			else if(ch==7) {
				 
			}
			else if (ch == 8) {
				System.out.println("Successfully Exit form Program....");
				break;
			}
		}
	}
}
