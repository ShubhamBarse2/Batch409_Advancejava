package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 2;
		Student s = ss.get(Student.class, id);
		s.setAddress("pune");
		s.setAge(33);
		s.setName("ritesh");

//		ss.update(s);
		ss.merge(s);

		System.out.println("Data is Updated...");

		tr.commit();
		ss.close();

	}

}
