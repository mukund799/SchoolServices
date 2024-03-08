package com.school.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.FeePayment;
import com.school.entity.StudentEntity;
import com.school.service.FeePaymentService;

@RestController
public class FeePamentController {
	@Autowired
	private FeePaymentService fps;
	@PostMapping("/payment/{rollNo}")
	public String FeePaymentForRollno(@RequestBody FeePayment fp, @PathVariable String rollNo) {
		StudentEntity s = new StudentEntity();
		s.setRollNo(rollNo);
	
		FeePayment result = new FeePayment();
		result.setMonth(fp.getMonth());
		result.setPaid(fp.getPaid());
		result.setYear(fp.getYear());
		result.setStudent(s);
		fps.save(result);
		return " payment addedd";
	}
}
