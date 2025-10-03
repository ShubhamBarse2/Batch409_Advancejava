package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department { // One

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dept_ID;
	String dept_Name;

	@OneToMany(mappedBy = "dept")
	List<Employee> emp;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDept_ID() {
		return dept_ID;
	}

	public void setDept_ID(int dept_ID) {
		this.dept_ID = dept_ID;
	}

	public String getDept_Name() {
		return dept_Name;
	}

	public void setDept_Name(String dept_Name) {
		this.dept_Name = dept_Name;
	}

	public Department(int dept_ID, String dept_Name, List<Employee> emp) {
		super();
		this.dept_ID = dept_ID;
		this.dept_Name = dept_Name;
		this.emp = emp;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Department [dept_ID=" + dept_ID + ", dept_Name=" + dept_Name + ", emp=" + emp + "]";
	}

}
