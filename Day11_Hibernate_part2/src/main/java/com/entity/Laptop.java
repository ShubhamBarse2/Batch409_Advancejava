package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {

	@Id
	int l_id;
	String name;

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(int l_id, String name) {
		super();
		this.l_id = l_id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Laptop [l_id=" + l_id + ", name=" + name + "]";
	}

}
