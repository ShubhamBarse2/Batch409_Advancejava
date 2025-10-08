package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Country;
import com.entities.Employee;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("springbeans.xml");
		Employee e1 = context.getBean("emp", Employee.class);
		System.out.println(e1);

	}

}
