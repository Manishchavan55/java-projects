package com.emsapp.app.daioimpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.emsapp.app.JDBCconnection.jdbcConnectivirty;
import com.emsapp.app.daio.EmployeeDaio;
import com.emsapp.app.model.Employee;

public class EmpoloyeeDaioImpl  implements EmployeeDaio{
	List<Employee> list=null;
	@Override
	public void addEmployee(Employee e) {
		 try {
			 Connection con= jdbcConnectivirty.getConnection();
			String s="insert into Employee values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1, e.getEid());
				ps.setString(2, e.getName()); 
				ps.setDouble(3, e.getSalary());
				ps.setString(4, e.getEmail());
				ps.execute();
				
				System.out.println("Employee Details  Added in Database successfully...");
					
			
		} catch (  SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
		
	}
	@Override
	public void createTable(String s) {
		try {
			 
			Connection con= jdbcConnectivirty.getConnection();
			String s1="create table "+s+"(id int,name varchar(30))";
		Statement smt=con.createStatement();
			smt.execute(s1);
			System.out.println("Table Created  Successfully..");
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Employee> viewEmployee() {
		list=new ArrayList<Employee>();
		try {
			Connection con= jdbcConnectivirty.getConnection();
			String s1="Select * from Employee";
		PreparedStatement ps=con.prepareStatement(s1);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setEmail(rs.getString(4));
				list.add(e);
				
			}
				
			
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	 
	public List<Employee> updateEmployee(Employee e) {
		
		try {
			Connection con= jdbcConnectivirty.getConnection();
			String s="update employee set name=?,salary=?,email=? where eid=?";
		PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1,e.getName());
			ps.setDouble(2, e.getSalary());
			ps.setString(3, e.getEmail());
			ps.setInt(4, e.getEid());
				ps.execute();
				
				System.out.println("Record Updated Successfully...!");
		} catch ( SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		return viewEmployee();
	}
	@Override
	public List<Employee> deleteEmployee(int id) {
		try {
			Connection con= jdbcConnectivirty.getConnection();
			String s1="delete from employee where eid=?";
		PreparedStatement ps=con.prepareStatement(s1);
			ps.setInt(1, id);
		
			ps.execute();
				System.out.println("Record Delete Successfully..");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.viewEmployee();
		 
	}
	@Override
	public void dropEmployeeTable(String s) {
		try {
			Connection con= jdbcConnectivirty.getConnection();
			String s1="drop table "+s+"";
		PreparedStatement ps=con.prepareStatement(s1);
		
			 ps.execute();
			 System.out.println("Table Drop Successfully...");
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Employee loginByIdName(int eid, String name) {
		Employee e=new Employee();
		Connection con= jdbcConnectivirty.getConnection();
		String sql="select * from employee where eid=? and name=?";
		
		try {
			PreparedStatement  ps=con.prepareStatement(sql);
				ps.setInt(1, eid);
				ps.setString(2, name);
				ResultSet rs= ps.executeQuery();
				while (rs.next()) {
					e.setEid(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setSalary(rs.getDouble(3));
					e.setEmail(rs.getString(4));
					
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return e;
	}

	 
	 
 

	 

}
