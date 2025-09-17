package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class Student extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name1");
		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);
		String city = request.getParameter("city");
		String mob = request.getParameter("mobile");
		long phoneNo = Long.parseLong(mob);

		PrintWriter out = response.getWriter();
//		out.println("<h1>" + name + "</h1>");
//		out.println("<h1>" + age1 + "</h1>");
//		out.println("<h1>" + city + "</h1>");
//		out.println("<h1>" + phoneNo + "</h1>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch409", "root", "root");
			PreparedStatement ps = c.prepareStatement("insert into student(age,name,city,phoneNo)values(?,?,?,?)");
			ps.setInt(1, age1);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setLong(4, phoneNo);
			int check = ps.executeUpdate();

			if (check > 0) {
				out.println("<h1 style='color:green'>" + "Data is inserted..." + "</h1>");
			} else {
				out.print("<h1 style='backgroundcolor:red'>" + "Data is Not inserted..." + "</h1>");
			}
			c.close();

		} catch (Exception e) {
			out.println("Error = " + e.getMessage());
		}

	}

}
