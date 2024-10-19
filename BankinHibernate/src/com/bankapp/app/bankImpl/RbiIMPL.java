package com.bankapp.app.bankImpl;

import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bankapp.app.HibernateConfig.HibernateUtil;
import com.bankapp.app.bankI.Rbi;
import com.bankapp.app.model.Account;

public class RbiIMPL implements Rbi{
Session session=HibernateUtil.getSessionFactory().openSession();
Account a=null;
Transaction tx=null;
Scanner sc=new Scanner(System.in);
	@Override
	public void createAccount() {
	 tx=session.beginTransaction();
	 a=new Account();
		System.out.println("Enter the Account number :");
		a.setAccno(sc.nextInt());
		System.out.println("Enter the account holder Name :");
		sc.next();
		a.setAccName(sc.next());
		System.out.println("Enter Mobile Number :");
		a.setMobNo(sc.next());
		System.out.println("Enter Adhar number :");
		a.setAdharNo(sc.next());
		System.out.println("Enter Gender :");
		a.setGender(sc.next());
		System.out.println("Enter the age : ");
		a.setAge(sc.nextInt());
		System.out.println("Enter the ammount to Deposite :");
		a.setBalance(sc.nextDouble());
		
		session.save(a);
		tx.commit();
		System.err.println("Account Created SuccessFully...");
				
	}


	@Override
	public void depositeMoney() {
		tx=session.beginTransaction();
		System.out.println("Enter the account Number :");
		Account a=session.get(Account.class,sc.nextInt());
		System.out.println("Enter the Ammount you want to Deposite :");
		double balance=sc.nextDouble();
		double bal= a.getBalance();
		a.setBalance(bal+balance);
		 
		System.out.println("Balance Added Successfully...");
		session.update(a);
		tx.commit();
		
		
	}

	@Override
	public void withdrawl() {
		tx=session.beginTransaction();
		System.out.println("Enter the account Number :");
		Account a=session.get(Account.class,sc.nextInt());
		System.out.println("Enter the Ammount you want to Withdrawl :");
		double balance=sc.nextDouble();
		double bal= a.getBalance();
		a.setBalance(bal-balance);
		 
		System.out.println("Balance Withdrawl Successfully...");
		session.update(a);
		tx.commit();
		
	}

	@Override
	public void balanceCheck() {
		tx=session.beginTransaction();
		 a=new Account();
			System.out.println("Enter the account Number :");
		 a.setAccno(sc.nextInt());
		 Account a1= session.get(Account.class, a.getAccno());
	
		tx.commit();
		System.out.println("BANK Balance is :"+ a1.getBalance());
		
		
	}


	@Override
	public void viewAccount() {
		tx=session.beginTransaction();
		a=new Account();
		System.out.println("Please Enter the account number :");
		a.setAccno(sc.nextInt());
		Account a1=session.get(Account.class,a.getAccno());
		tx.commit();
		if(a1!=null) {
			System.out.println(a1.getAccno());
			System.out.println(a1.getAccName());
			System.out.println(a1.getAdharNo());
			System.out.println(a1.getGender());
			System.out.println(a1.getAge());
			 
		}
	}

}
