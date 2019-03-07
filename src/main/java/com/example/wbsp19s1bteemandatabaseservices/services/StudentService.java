package com.example.wbsp19s1bteemandatabaseservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemandatabaseservices.model.*;
import com.example.wbsp19s1bteemandatabaseservices.repositories.StudentRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class StudentService {

	@Autowired
	StudentRepository studentRepositroy;
	
	@PostMapping("/api/student")
	public User createStudent(@RequestBody Student student) {
	  		return studentRepositroy.save(student);
	}
	
	@GetMapping("/api/student")
	public List<Student> findAllStudent() {
	   return (List<Student>)studentRepositroy.findAll();
	}
}
