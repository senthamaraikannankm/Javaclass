package com.dal.control;
import com.dal.model.*;
import com.dal.view.Employee;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class EmployeeControl {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<EmployeeModel> emplst = new ArrayList<EmployeeModel>();
	EmployeeModel emp;
	
	public void addEmployee() {
		
		emp = new EmployeeModel();
		
		System.out.println("Add Employee sno");
		
		emp.setEmpno(sc.nextInt());
		System.out.println("Add Employee  name");
		emp.setEname(sc.next());
		//viewEmployee();
		emplst.add(emp);
		System.out.println("emplist =" + emplst);
	
	}
	
	public ArrayList<EmployeeModel> getEmplst() {
		return emplst;
	}

 

	public void viewEmployee()
	{
		System.out.println("First class instance two - " +emp.getEmpno());
		System.out.println("First class instance two - " +emp.getEname());
		
	}
	
	public void viewEmployee(	ArrayList<EmployeeModel>  e)
	{
		int i=0;
		for (EmployeeModel employeeModel : e) {
                  
			System.out.println("Emp Number - "+ ++i +" - "+employeeModel.getEmpno());
			System.out.println("Emp Name - "+ i +" - " +employeeModel.getEname());
			
			
		}
		
		
		
		
		
		
	}
	
	
	public void writeEmp() throws IOException
	{
		try{				 
			FileOutputStream fos = new FileOutputStream("dedalus2.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);	
			
			
			System.out.println("\n1\n"); 
			oos.writeObject(emplst);
			System.out.println("\n2\n");
			System.out.println("Serilized to file dedalus.txt");
			
		
			
			oos.close();
			fos.close();
			}
	
		
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
		catch(IOException fnf)
		{
			System.out.println("No IOException "  + fnf.getMessage() + fnf.getLocalizedMessage() );
		}
		catch(Exception e) {
			System.out.println("No file" + e.getMessage() + e.getLocalizedMessage()  );
		}
		
	}
	
 	public void readEmp() throws IOException{
 		
 		
		try{
			
			
			FileInputStream fis = new FileInputStream("dedalus2.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// emp1 = new ArrayList<EmployeeModel>();
			ArrayList<EmployeeModel>  emp1 = (ArrayList<EmployeeModel> ) ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
			viewEmployee(emp1);
			ois.close();
			fis.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
			}
		catch(IOException fnf)
		{
			System.out.println("No IOException "  + fnf.getMessage() + fnf.getLocalizedMessage() );
		}
		catch(Exception e) {
			System.out.println("No file" + e.getMessage() + e.getLocalizedMessage()  );
		}
 		
 	}

}
