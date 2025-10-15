package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entities.Employee;
import com.tka.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/add")
	public String insertData(@RequestBody Employee emp) {
		String msg = service.insertData(emp);
		return msg;
	}

	@DeleteMapping("/delete")
	public String deleteData(@RequestParam int empID) {
		String msg = service.deleteData(empID);
		return msg;
	}

	@PutMapping("/update/{empID}")
	public String updateData(@RequestBody Employee emp, @PathVariable int empID) {
		String msg = service.udateData(emp, empID);
		return msg;
	}

	@GetMapping("/getsinglerecord/{empID}")
	public Employee getSingleRecord(@PathVariable int empID) {
		Employee e1 = service.getSingleData(empID);
		return e1;

	}

	@GetMapping("/getAllrecord")
	public List<Employee> getAllRecord() {
		List<Employee> list = service.getAllRecord();
		return list;

	}
}
