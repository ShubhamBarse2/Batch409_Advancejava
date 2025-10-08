package com.entities;

public class Employee {

	int empId;
	String empName;
	String Salary;
	Country con;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public Country getCon() {
		return con;
	}

	public void setCon(Country con) {
		this.con = con;
	}

	public Employee(int empId, String empName, String salary, Country con) {
		super();
		this.empId = empId;
		this.empName = empName;
		Salary = salary;
		this.con = con;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", Salary=" + Salary + ", con=" + con + "]";
	}

}
