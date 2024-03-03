package com.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/start")
	public String test() {
		return "Hello bachho, Kaise ho bete!!";
	}
	
	
	// to add student details into the database
	@PostMapping("/addDetails")
	public String addDetails() {
		
		return "Student Details Addedd.";
	}
}
