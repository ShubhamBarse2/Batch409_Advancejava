package com.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Country {

	@Value("91")
	int c_id;
	@Value("IND")
	String c_Name;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_Name() {
		return c_Name;
	}

	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}

	public Country(int c_id, String c_Name) {
		super();
		this.c_id = c_id;
		this.c_Name = c_Name;
	}

	@Override
	public String toString() {
		return "Country [c_id=" + c_id + ", c_Name=" + c_Name + "]";
	}

}
