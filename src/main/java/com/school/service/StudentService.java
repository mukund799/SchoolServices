package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.StudentEntity;
import com.school.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository sr;
	public  StudentEntity saveStudentData(StudentEntity se) {
		StudentEntity ret = sr.save(se);
		return ret;
	}
	
}
