package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class StudentDao {

	public void insertData() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Student s = new Student();
		s.setName("ram");
		s.setAddress("akola");
		s.setAge(29);

//		ss.save(s);
		ss.persist(s);

		System.out.println("Data is inserted...");

		tr.commit();
		ss.close();

	}
	
	
	public void updateData() {
		
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
