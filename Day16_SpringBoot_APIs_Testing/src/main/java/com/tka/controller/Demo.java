package com.tka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/w3school")
public class Demo {

	@GetMapping("/java")
	public String firstAPI() {
		return "java is an OOP Language....!";
	}

	@RequestMapping(value = "/css", method = RequestMethod.PUT)
	public String thirdAPI() {
		return "CSS used for style pages...!";
	}

	@PostMapping("/html")
	public String secondAPI() {
		return "html is an hypertext markup language !";
	}
}
