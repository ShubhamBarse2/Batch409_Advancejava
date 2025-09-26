package com.service;

import com.dao.StudentDao;

public class StudentService {

	public void insertData() {
		StudentDao sd = new StudentDao();
		sd.insertData();
	}

	public void updateData() {
		StudentDao sd = new StudentDao();
		sd.updateData();
	}
}
