package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.StudentEntity;
import com.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/start")
	public String test() {
		return "Hello bachho, Kaise ho bete!!";
	}
	
	
	// to add student details into the database
	@Autowired
	StudentService service;
	@PostMapping("/addDetails")
	public String addDetails(@RequestBody StudentEntity s) {
		String rn = s.getClassName()+s.getRollNo();
		s.setRollNo(rn);
		StudentEntity rs = service.saveStudentData(s);
		if (rs != null)
		 return "Student Details Addedd.";
		else return " student details not saved";
	}
}