package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.FeePayment;
import com.school.entity.StudentEntity;
import com.school.repository.FeePaymentRepository;
import com.school.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository sr;
	@Autowired
	FeePaymentRepository fs;
	public  StudentEntity saveStudentData(StudentEntity se) {
		StudentEntity s = sr.findById(se.getRollNo()).orElse(null);
		//Student savedStudent = studentRepository.save(student);
        
        
		if(s == null) {
			StudentEntity result =  sr.save(se);
			// Create fee payment entry for the student
	        FeePayment feePayment = new FeePayment();
	        feePayment.setStudent(result);
	        // Set other fee payment details
	        
	        fs.save(feePayment);
	        return result;
		}
		return null;
	}
	public List<StudentEntity> getAllDetailsOfStudent() {
		
		return sr.findAll();
		
	}
	
	public StudentEntity getDetailsOfStudent(String id) {
		return sr.findById(id).orElse(null);
	}
	
	public StudentEntity getDetailsByName(String name) {
		return sr.findByName(name).orElse(null);
	}
}
