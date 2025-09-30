package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Student;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

// SQL : insert into student(age,name,city)values(24,'suraj','pune');
// HQL : insert into Student(age,name,city)values(=:age,=:name,=:city);

		String hqlQuery = "insert into studentrecord(name,city,age)values(:name,:city,:age)";

		MutationQuery query = ss.createNativeMutationQuery(hqlQuery);
		query.setParameter("name", "suraj");
		query.setParameter("city", "pune");
		query.setParameter("age", 23);
		query.executeUpdate();

		System.out.println("Data is inserted...");

		tr.commit();
		ss.close();

	}

}
