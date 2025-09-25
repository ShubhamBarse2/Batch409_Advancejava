package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Student s = new Student();
		s.setStud_id(1);
		s.setName("shyam");
		s.setAddress("pune");
		s.setAge(24);

//		ss.save(s);
		ss.persist(s);

		System.out.println("Data is inserted...");

		tr.commit();
		ss.close();

	}

}
