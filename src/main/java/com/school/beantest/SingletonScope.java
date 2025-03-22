package com.school.beantest;

import org.springframework.stereotype.Component;

@Component
public class SingletonScope {

	public String BeanTest(String str) {
		return "I am Singleton Bean. you can create as many instance i will have same instance address.";
	}
}
