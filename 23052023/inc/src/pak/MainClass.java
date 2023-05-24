 

package pak;

import java.util.Scanner;

class Employee {

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
		sal = new Salary();
		sal.setBasic(this.basic);		
	}

	int empno;
	String ename = "Asha";
	double basic;
	
	Salary sal;
	
	public Employee() {
	  System.out.println("Net Sal Calculator \n Enter Basic : ");
	  Scanner sc = new Scanner(System.in);	  
	  setBasic(sc.nextDouble());
 
	}
	
	public Employee(int x) {
		  this("Mani");
		  this.empno=x;
		  System.out.println("From Employee Constructor" + x);
	}
	
	public Employee(String str) {
		  
		  System.out.println("From Employee Constructor" + str);
	}
	
	public String getDetails() {		
		
		return (empno + " -- " + ename + " --- " + sal );
	}

	
	
	
}

class Manager extends Employee {
	String dept = "IT";
	

	public Manager() {
		super(888);  // used to invoke base clas constructor
		 
		System.out.println("From Mgr Constr");
		
	}
	
	public Manager(String s) {
		this();		
		System.out.println("call from this");
	}
	
	public String getDetails() {		
		 return super.getDetails()+ "--  " + super.ename +" Dpt " +  dept;
	}

}

public class MainClass {

	public static void main(String[] args) {
		Employee emp = new Employee();
		System.out.println(emp.getDetails());

		//Manager mgr = new Manager();
		//System.out.println(mgr.getDetails());

	}

}