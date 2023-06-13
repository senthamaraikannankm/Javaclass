package com.dal.control;
import com.dal.model.*;
import com.dal.view.Employee;
import com.dal.view.EmployeeModel;
import com.dal.view.MyDbConnection;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.Statement;

public class EmployeeControl {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<EmployeeModel> emplst = new ArrayList<EmployeeModel>();
	EmployeeModel emp;
	
	public EmployeeModel addEmployee() {
		
		emp = new EmployeeModel();
		
		System.out.println("Add Employee sno");		
		emp.setEmpno(sc.nextInt());
		System.out.println("Add Employee  name");
		emp.setEname(sc.next());
		//viewEmployee();
		emplst.add(emp);
		System.out.println("emplist =" + emplst);
		
		return emp;
	
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
		try {
		
		Iterator<EmployeeModel> empitrate = emplst.iterator();
		while(empitrate.hasNext()){
		System.out.println(empitrate.next());
		}
		
		}
		catch(Exception emg) { 
			System.out.println("No file" + emg.getMessage() + emg.getLocalizedMessage()  );
		}
		
		
	}
	
	public void insertEmployee(	EmployeeModel  e)
	{
	 
		try {
		
	 
			
			EmployeeDao dac = new EmployeeDao();
			dac.insertEmployee(e);
		 
		
		}
		catch(Exception emg) { 
			System.out.println("No file" + emg.getMessage() + emg.getLocalizedMessage()  );
		}
		
		
	}
	
	public void showEmployee()
	{
	 
		try {
		
			EmployeeDao dac = new EmployeeDao();
			dac.showEmployee();
			
		
		}
		catch(Exception emg) { 
			System.out.println("No file" + emg.getMessage() + emg.getLocalizedMessage()  );
		}
		
		
	}
	

	
	public void updateEmployee(EmployeeModel e)
	{
	 
		try {
		
			EmployeeDao dac = new EmployeeDao();
			dac.updateEmployee(e);			
		
		}
		catch(Exception emg) { 
			System.out.println("No file" + emg.getMessage() + emg.getLocalizedMessage()  );
		}
		
		
	}
	
	
	public void deleteEmployee(EmployeeModel e)
	{
	 
		try {
		
			EmployeeDao dac = new EmployeeDao();
			dac.deleteEmployee(e.getEmpno());			
		
		}
		catch(Exception emg) { 
			System.out.println("No file" + emg.getMessage() + emg.getLocalizedMessage()  );
		}
		
		
	}
	
	
	
	 public  static class InnerClass {
		      
			ArrayList<EmployeeModel> emplstInner = new ArrayList<EmployeeModel>();

	        public void viewEmployee(ArrayList<EmployeeModel>  e) {
	            System.out.println("Inner Class");
	            // System.out.println("instanceVariable == " + instanceVariable); 
	            
	            int i=0;
	    		for (EmployeeModel employeeModel : e) {
	                      
	    			System.out.println("Emp Number - "+ ++i +" - "+employeeModel.getEmpno());
	    			System.out.println("Emp Name - "+ i +" - " +employeeModel.getEname());
	    			
	    			
	    		}
	            
	            
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




 class MyDbConnection {
	static Connection con;
	
	private static MyDbConnection instance = null;
    private MyDbConnection() {

	}
    
    public static MyDbConnection getInstance() {
        if (instance == null) {
            instance = new MyDbConnection();
        }
        return instance;
    }
	
	public static Connection getMyConnection() {

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "SriRam$10");
			System.out.println(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
	

	public static void main(String[] args) {
		System.out.println(getMyConnection());

	}

}











class EmployeeDao {

	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	public void insertEmployee(EmployeeModel emp) {

		con = MyDbConnection.getMyConnection();
		
		int continewflowflag= 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from dalemp  where empno = "+emp.getEmpno()+"");
		 
			
			while (rs.next()) { 
				break;
			}
			continewflowflag=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(continewflowflag==1)
		{
	
		
		try {
			ps = con.prepareStatement("insert into dalemp values(?,?)");
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getEmpno());

			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " got inserted into DB successfully!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		}

	}

	public void showEmployee() {
		con = MyDbConnection.getMyConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from dalemp");
			while (rs.next()) {
				System.out.println(rs.getInt(2) + " -- " + rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void updateEmployee(EmployeeModel emp) {
		con = MyDbConnection.getMyConnection();
		try {

			ps = con.prepareStatement("update dalemp set empname = ? where empno = ?");
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getEmpno());

			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " employee(s) updated successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int empno) {
		con = MyDbConnection.getMyConnection();
		try {
			ps = con.prepareStatement("delete from dalemp where EMPNO = ?");
			ps.setInt(1, empno);
			
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " employee(s) deleted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


