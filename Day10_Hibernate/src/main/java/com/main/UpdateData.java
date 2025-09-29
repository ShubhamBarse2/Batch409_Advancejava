package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Student;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

//		update SQLQuery  : update student set name ="rohit" where id = 2;
//		HQL Query : update Student set name =:myName where id =: myid; 

		String hqlQuery = "update Student set address=:address where id=:myid ";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("address", "akola");
		query.setParameter("myid", 4);
		query.executeUpdate();

		System.out.println("Data is Updated...");

		tr.commit();
		ss.close();

	}

}
