package com.school.beantest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PrototypeScope {

	@Scope("prototype")
	public String beantest(String str) {
		return "bean2Prototype";
	}
}
