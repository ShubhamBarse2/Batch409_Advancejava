package com.tka;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		if (username.equals("ram@gmail.com") && password.equals("Ram@123")) {
			out.println("Login Successfully..!");

			RequestDispatcher rs = req.getRequestDispatcher("profile.jsp");
			rs.include(req, resp);

		} else {
			out.println("Invalid Credentials...!");
			RequestDispatcher rs = req.getRequestDispatcher("login.html");
			rs.forward(req, resp);
		}

	}

}
