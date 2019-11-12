package com.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Student;
import com.beans.StudentRegistration;
import com.beans.StudentRegistrationReply;

@RestController
public class StudentRegistrationController {
	
	private static final Logger logger = LogManager.getLogger(StudentRegistrationController.class);
	
	@PostMapping("/register/student")
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		logger.info("In registerStudent");

		StudentRegistrationReply stdregreply = new StudentRegistrationReply();
		StudentRegistration.getInstance().add(student);
		
		// We are setting the below value just to reply a message back to the caller
		stdregreply.setName(student.getName());
		stdregreply.setAge(student.getAge());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus("Successful");
		return stdregreply;
	}

}
