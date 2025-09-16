package com.jbk;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/submit")
public class Student extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name1");
		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);
		String city = request.getParameter("city");
		String mob = request.getParameter("mobile");
		long phoneNo = Long.parseLong(mob);

		System.out.println(name);
		System.out.println(age1);
		System.out.println(city);
		System.out.println(phoneNo);

	}

}
