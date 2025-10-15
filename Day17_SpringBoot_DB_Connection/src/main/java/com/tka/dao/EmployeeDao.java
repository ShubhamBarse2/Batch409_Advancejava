package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Employee emp) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(emp);
		tx.commit();
		session.close();

		String msg = "Data is Inserted...";
		return msg;
	}

	public String deleteData(int empID) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee e1 = session.get(Employee.class, empID);
		session.remove(e1);
		tx.commit();
		session.close();

		String msg = "Data is deleted...";
		return msg;
	}

	public String updateData(Employee emp, int empID) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee e1 = session.get(Employee.class, empID);
		e1.setName(emp.getName());
		e1.setSalary(emp.getSalary());
		session.merge(e1);
		tx.commit();
		session.close();

		String msg = "Data is udated...";
		return msg;
	}

	public Employee getSingleData(int empID) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String hqlQuery = "from Employee where empID =:empID";
		Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
		query.setParameter("empID", empID);
		Employee e1 = query.getSingleResult();
		tx.commit();
		session.close();
		return e1;
	}

	public List<Employee> getAllRecord() {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String hqlQuery = "from Employee";
		Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
		List<Employee> list = query.list();
		tx.commit();
		session.close();
		return list;
	}
}
