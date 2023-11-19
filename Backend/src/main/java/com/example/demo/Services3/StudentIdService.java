package com.example.demo.Services3;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;




@Service
public class StudentIdService implements StudentIdGenerator{

	private static int nextId=1;
	
	public long generateStudentId(Long id) {
		 return Long.parseLong("23072010" + String.format("%03d", nextId++));
		
	}
}
