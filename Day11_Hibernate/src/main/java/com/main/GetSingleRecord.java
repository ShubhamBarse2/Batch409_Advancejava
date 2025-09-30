package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Student;

public class GetSingleRecord {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

//		SQL : select * from student where id =2;
//		HQL : from Student where id =: id;

		String hqlQuery = "from Student where id=:myid";

		Query<Student> query = ss.createQuery(hqlQuery, Student.class);
		query.setParameter("myid", 2);

		Student s = query.uniqueResult();
		System.out.println(s);

		tr.commit();
		ss.close();
	}

}
