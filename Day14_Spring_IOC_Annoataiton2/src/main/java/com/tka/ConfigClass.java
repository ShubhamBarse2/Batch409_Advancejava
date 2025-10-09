package com.tka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

	@Bean
	public Employee objEmp() {
		return new Employee();
	}

}
