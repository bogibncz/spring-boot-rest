package com.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Student;
import com.beans.StudentRegistration;

@RestController
public class StudentUpdateController {
	
	private static final Logger logger = LogManager.getLogger(StudentUpdateController.class);
	
	@PutMapping("/update/student")
	public String updateStudentRecord(@RequestBody Student student) {
		logger.info("In updateStudentRecord");
		return StudentRegistration.getInstance().upDateStudent(student);
	}

}
