package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentRecord")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_id;
	private String name;
	
	@Column(name = "city")
	private String address;
	private int age;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(int stud_id, String name, String address, int age) {
		super();
		this.stud_id = stud_id;
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}

}
