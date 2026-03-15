package com.practice.spring_annotation_based;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
	
	@Autowired
	private Laptop laptop;
	
	@Value("Raman")
	private String name;
	
	public void code() {
		System.out.println(name + " is coding.");
		laptop.compile();
	}
	
}
