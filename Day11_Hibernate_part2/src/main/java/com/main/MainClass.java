package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Laptop;
import com.entity.Student;

public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Laptop l1 = new Laptop();
		l1.setL_id(100001);
		l1.setName("hp");
		ss.persist(l1);

		Student s = new Student();
		s.setName("nandini");
		s.setLapt(l1);

		ss.persist(s);

		System.out.println("Data is inserted...");

		tr.commit();
		ss.close();

	}
}
