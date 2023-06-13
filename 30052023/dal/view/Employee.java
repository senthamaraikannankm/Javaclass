package com.dal.view;

import java.util.function.BiPredicate;
import java.util.Scanner;

import com.dal.control.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Employee {

	public static void main(String[] args) {

		try {

			String un = null;
			String pwd = null;
			int a =0;
		
				BiPredicate<String, String> validateUsernamePassword = (username, password) ->
			    username.equals("pass") && password.equals("pass");

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();
			

			if (validateUsernamePassword.test(un, pwd)) {//if (un.equals("pass") && pwd.equals("pass")) {
				
				System.out.print("Loading ... ");
				Thread.sleep(500);
				
			do {
				System.out.print("...");
				Thread.sleep(300);
				a++;
			}while(a<10);
			
				Thread.sleep(1000);
				System.out.println("");
				System.out.println("Welcome " + un);
			} else {
				throw new UserNotFoundException();
			}

			int x = 190;
			int cho = 0;
			Scanner sc = new Scanner(System.in);

			EmployeeControl ed = new EmployeeControl();

			do {

				System.out.println("option : ");
				cho = sc.nextInt();

				switch (cho) {

				case 1: {
					ed.addEmployee();
					System.out.println(ed);
					ed.toString();
					break;
				}

				case 2: {
					ed.viewEmployee();
					
					ed.viewEmployee(ed.getEmplst());
					
					
					EmployeeControl.InnerClass ic = new EmployeeControl.InnerClass();
					ic.viewEmployee(ed.getEmplst());
					
					break;
				}

				case 3: {
					ed.writeEmp();
					break;
				}

				case 4: {
					ed.readEmp();
					break;
				}
				case 5: {
					ed.readEmp();
					break;
				}
				case 6: {
					ed.readEmp();
					break;
				}
				default:
					System.out.println("Enter a valid number ");

				}

			} while (cho < 10);
			System.out.println("cho :" + cho );
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Enter a valid number ");
		}

		System.out.println("Exit");
		System.exit(0);

	}

}

class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		System.out.println("From unfe constr");

	}

	@Override
	public String toString() {
		return "UserNotFoundException tostring";
	}

}
