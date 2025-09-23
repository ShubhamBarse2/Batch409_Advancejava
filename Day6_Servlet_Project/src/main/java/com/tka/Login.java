package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch409", "root", "root");
			PreparedStatement ps = c.prepareStatement("select * from employee where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				out.println("Valid User...!");

				HttpSession session = req.getSession();
				session.setAttribute("empName", rs.getString(1));
				session.setAttribute("department", rs.getString(2));
				session.setAttribute("email", rs.getString(3));
				session.setAttribute("mobNo", rs.getLong(4));

				RequestDispatcher rs1 = req.getRequestDispatcher("/profile.jsp");
				rs1.include(req, resp);

			} else {
				out.println("InValid User...!");
				RequestDispatcher rs1 = req.getRequestDispatcher("login.html");
				rs1.include(req, resp);
			}

		} catch (Exception e) {
			out.println("Error" + e.getMessage());
		}

	}

}
