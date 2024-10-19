package com.bankapp.app.client;

import java.util.Scanner;

import com.bankapp.app.bankI.Rbi;
import com.bankapp.app.bankImpl.RbiIMPL;

public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			Rbi r=new RbiIMPL();
			System.out.println("*********BANK APP in HIBERNATE***********");
			System.out.println("1.Create Account: \n"
					+ "2.View Account:"
					+ "\n3.Deposite Ammount:"
					+ "\n4.Withdrawl:"
					+ "\n5.Balance Check:\n"
					+ "6.exit...");
			System.out.println("Enter the choice :");
			int ch=sc.nextInt();
			if(ch==1)
			{
				r.createAccount();
			}
			else if(ch==2) {
				r.viewAccount();
			}
			else if(ch==3) {
				r.depositeMoney();
			}
			else if(ch==4) {
				r.withdrawl();
			}
			else if(ch==5) {
			
				r.balanceCheck();
			}
			else if(ch==6) {
				break;
			}
		}
	}
}
