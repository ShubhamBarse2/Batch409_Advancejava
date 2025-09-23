package com.tka;

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

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("empName");
		String dept = req.getParameter("department");
		String email = req.getParameter("email");
		String phn = req.getParameter("mobNo");

		long phoneNo = Long.parseLong(phn);

		String pass = req.getParameter("password");

		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch409", "root", "root");
			PreparedStatement ps = c
					.prepareStatement("insert into employee(empName,department,email,mobNo,password)values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setString(3, email);
			ps.setLong(4, phoneNo);
			ps.setString(5, pass);
			int check = ps.executeUpdate();

			if (check > 0) {
				out.println("<h1 style='color:green'>" + "Register Succcessfully...!" + "</h1>");
				resp.sendRedirect("login.html");
			} else {
				out.print("<h1 style='backgroundcolor:red'>" + "Data is Not inserted..." + "</h1>");
			}
			c.close();

		} catch (Exception e) {
			out.println("Error = " + e.getMessage());
		}

	}

}
