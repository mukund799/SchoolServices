package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.FeePayment;
import com.school.repository.FeePaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FeePaymentService {
	@Autowired
	FeePaymentRepository fpr;
 public String save(FeePayment p) {
	 fpr.save(p);
	 return "";
 }
}
