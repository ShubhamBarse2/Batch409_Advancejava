package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import com.entity.Student;

import jakarta.persistence.criteria.Root;

public class GetAllRecord {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

//		SQL : Select * from student 
//		HQL : from Student 
//		String hqlQuery = "from Student";
//		org.hibernate.query.Query<Student> query = ss.createQuery(hqlQuery, Student.class);
//		List<Student> list = query.list();
//		Query query = ss.createQuery(hqlQuery);
//		List<Student> list = query.getResultList();

		HibernateCriteriaBuilder hcb = ss.getCriteriaBuilder();
		JpaCriteriaQuery<Student> cq = hcb.createQuery(Student.class);
		Root<Student> s = cq.from(Student.class);
		cq.select(s);

		Query<Student> query = ss.createQuery(cq);
		List<Student> list = query.list();

		for (Student student : list) {
			System.out.println(student);
		}

		tr.commit();
		ss.close();

	}

}
