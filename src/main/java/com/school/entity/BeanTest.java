package com.school.entity;

import org.springframework.stereotype.Component;

@Component
public class BeanTest {

	public String BeanTest(String str) {
		return "I am bean"+str;
	}
}
