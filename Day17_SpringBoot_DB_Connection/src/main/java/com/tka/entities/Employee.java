package com.tka.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeRecord")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int empID;
	String name;
	String salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empID, String name, String salary) {
		super();
		this.empID = empID;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", salary=" + salary + "]";
	}

}
