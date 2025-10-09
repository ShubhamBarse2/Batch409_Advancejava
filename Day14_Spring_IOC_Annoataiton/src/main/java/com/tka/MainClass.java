package com.tka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Employee e1 = context.getBean(Employee.class);
		Employee e2 = context.getBean(Employee.class);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e1 == e2);

	}

}
