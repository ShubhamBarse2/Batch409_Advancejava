package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.EmployeeDao;
import com.tka.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public String insertData(Employee emp) {
		String msg = dao.insertData(emp);
		return msg;
	}

	public String deleteData(int empID) {
		String msg = dao.deleteData(empID);
		return msg;
	}

	public String udateData(Employee emp, int empID) {
		String msg = dao.updateData(emp, empID);
		return msg;
	}

	public Employee getSingleData(int empID) {
		Employee e1 = dao.getSingleData(empID);
		return e1;
	}

	public List<Employee> getAllRecord() {
		List<Employee> list = dao.getAllRecord();
		return list;
	}

}
