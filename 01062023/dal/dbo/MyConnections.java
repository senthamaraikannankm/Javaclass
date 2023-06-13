package com.dal.dbo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MyConnections {

	static Connection con;
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","SriRam$10");
		
		System.out.println(con);
		
		
		
		sortexam s = new sortexam(); 
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}


 


  class Student implements Comparable<Student>,Serializable{
	private int sid;
	private String sname;
	private transient int age; 
	private int marks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, int age, int marks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.marks = marks;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + ", marks=" + marks + "]";
	}

	@Override
	public int compareTo(Student s1) {
		
		return this.sid - s1.sid;
	}
	
	//Anonyomous class
	public static Comparator<Student> nameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			
			return (s1.getSname().compareTo(s2.getSname()));
		}
		
		
	};

	//Anonyomous class
		public static Comparator<Student> marksComparator = new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				
				return (s1.getMarks() - s2.getMarks());
			}
			
			
		};
}
  
  
 

    class sortexam {

  	public sortexam () {
  		int[] intArr = {5,6,4,15,11};
  		Arrays.sort(intArr);
  		System.out.println("Sorted intArr : " + Arrays.toString(intArr));

  		String[] strArr = {"DeepDas","Arla","Farnaz","Karthick"};
  		Arrays.sort(strArr);
  		System.out.println("Sorted strArr : " + Arrays.toString(strArr));

  		
  		List<String> strList = new ArrayList<String>();
  		strList.add("Pranthi");
  		strList.add("Afeed");
  		strList.add("Venkat");
  		strList.add("Sayantan");
  		
  		System.out.println("StrList : " + strList);
  		Collections.sort(strList);
  		System.out.println("Sorted StrList : " + strList);
  		
  		Student[] stArray = new Student[3];
  		stArray[0] = new Student(10,"Kushdeep",25,90);
  		stArray[1] = new Student(30,"Bhavana",23,80);
  		stArray[2] = new Student(20,"Gowthami",22,95);
  		
  		Arrays.sort(stArray);
  		System.out.println("Sorted Student Array :" + Arrays.toString(stArray));
  		
  		Arrays.sort(stArray,Student.nameComparator);
  		System.out.println("Sorted Student Array w.r.t Name :" + Arrays.toString(stArray));
  		
  		Arrays.sort(stArray,Student.marksComparator);
  		System.out.println("Sorted Student Array w.r.t Marks :" + Arrays.toString(stArray));
  		
  		
  		
  	}

  }