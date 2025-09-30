package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_id;
	private String name;
	
	@OneToOne
	Laptop lapt;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int stud_id, String name, Laptop lapt) {
		super();
		this.stud_id = stud_id;
		this.name = name;
		this.lapt = lapt;
	}

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Laptop getLapt() {
		return lapt;
	}

	public void setLapt(Laptop lapt) {
		this.lapt = lapt;
	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", name=" + name + ", lapt=" + lapt + "]";
	}
	
	
	

}
