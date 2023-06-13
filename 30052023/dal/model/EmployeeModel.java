package com.dal.model;

import java.io.Serializable;

public class EmployeeModel implements Serializable{
	 
	public String toString() {
		return "EmployeeModel [empno=" + empno + ", ename=" + ename + "]";
	}


	private int empno;
	private String ename;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	
	
	}
