package com.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Student;
import com.beans.StudentRegistration;
import com.beans.StudentRegistrationReply;

@RestController
public class StudentController {
	
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	
	@GetMapping("/student/allstudent")
	public List<Student> getAllStudents() {
		return StudentRegistration.getInstance().getStudentRecords();
	}
	
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
	
	@PutMapping("/update/student")
	public String updateStudentRecord(@RequestBody Student student) {
		logger.info("In updateStudentRecord");
		return StudentRegistration.getInstance().upDateStudent(student);
	}
	
	@DeleteMapping("/delete/student/{regdNum}")
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		logger.info("In deleteStudentRecord");
		return StudentRegistration.getInstance().deleteStudent(regdNum);
	}

}
