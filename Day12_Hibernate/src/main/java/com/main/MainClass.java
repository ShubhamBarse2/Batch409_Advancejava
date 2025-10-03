package com.main;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Department d = new Department();
		d.setDept_Name("Developer");

		Employee e1 = new Employee();
		e1.setEmpId(10001);
		e1.setName("dhiraj");
		e1.setDept(d);

		Employee e2 = new Employee();
		e2.setEmpId(10002);
		e2.setName("viraj");
		e2.setDept(d);

		Employee e3 = new Employee();
		e3.setEmpId(10003);
		e3.setName("raj");
		e3.setDept(d);

		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		
		d.setEmp(list);

		ss.persist(d);
		ss.persist(e1);
		ss.persist(e2);
		ss.persist(e3);

		System.out.println("Data is inserted...");

		tr.commit();
		ss.close();

	}
}
