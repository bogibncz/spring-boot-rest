package com.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beans.StudentRegistration;

@RestController
public class StudentDeleteController {

	private static final Logger logger = LogManager.getLogger(StudentDeleteController.class);

	@DeleteMapping("/delete/student/{regdNum}")
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		logger.info("In deleteStudentRecord");
		return StudentRegistration.getInstance().deleteStudent(regdNum);
	}

}
