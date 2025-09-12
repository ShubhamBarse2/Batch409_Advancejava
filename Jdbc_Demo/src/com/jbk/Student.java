package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch409", "root", "root");
		Statement s = c.createStatement();
		int a = s.executeUpdate("insert into student(id,name,city)values(1,'ram','pune')");
		if (a > 0) {
			System.out.println("Data IS Inserted...");
		} else {
			System.out.println("Data IS Not Inserted...");
		}

		c.close();
	}

}
