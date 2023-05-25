package inha;

import java.util.Scanner;

abstract class Bird {
	int weight;
	int height = 45;

	public abstract void eat();

	Bird() {
		System.out.println("Bird eating");

	}

	public void fly() {
		System.out.println("Bird eating");
	}
	
	public void fly1() {
		System.out.println("Bird eating");
	}
}

class Parrot extends Bird {
	public void eat() {
		System.out.println("Parrot eating");
	}
	
	public void fly() {
		super.fly1();
		System.out.println("Parrot eating");
	}
	
	
	
}


interface  LeavePL{	
	int pl=30; 
	 void getPL();  
}
interface  LeaveML{	
	int ml=200; 
	 void getML();  
}


interface  LeaveSL  {	 
	int sl=30; 
	int pl=40;
	 void getSL();	
}


interface  LeaveTotal extends LeavePL,LeaveSL,LeaveML {	 
	int totalLeave = LeavePL.pl+ml+sl; 
	int pl=100;
	 void listLeave();	
	 
}

class EmpLeaveDetails extends  Parrot implements LeaveTotal {
	int totalLeave;
	Scanner sc = new Scanner(System.in);	
	public void getPL() {		
		  System.out.println("PL: " + LeavePL.pl);			   
	}
	
	public void getML() {		
		  System.out.println("ML: " + ml);		
	}
	
	
	public void getSL() {		
		  System.out.println("SL : "  + sl);		
	}
	
	
	public void listLeave() {		
		  System.out.println("listLeave: " + LeaveTotal.totalLeave );		
	}
	
	
	
}

public class AbsClass {

	public static void main(String[] args) {

		//Parrot p = new Parrot();
		//p.eat();

		//Bird b = new Parrot();
		//b.eat();
		
		EmpLeaveDetails ld = new EmpLeaveDetails();
		ld.eat(); // calling class
		ld.getPL();
		ld.getML();
		ld.getSL();
		ld.listLeave();		
	}

}