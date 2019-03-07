package com.example.wbsp19s1bteemandatabaseservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemandatabaseservices.model.*;
import com.example.wbsp19s1bteemandatabaseservices.repositories.FacultyRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class FacultyService {

	@Autowired
	FacultyRepository facultyRepository;
	
	@PostMapping("/api/faculty")
	public User createFaculty(@RequestBody Faculty faculty) {
	  		return facultyRepository.save(faculty);
	}
	
	@GetMapping("/api/faculty")
	public List<Faculty> findAllFaculty() {
	   return (List<Faculty>)facultyRepository.findAll();
	}
	
	@GetMapping("/api/faculty/{id}")
	public Faculty findFacultyById(
			@PathVariable("id") Integer id) {
		return facultyRepository.findById(id).get();
	}
	
	@PutMapping("/api/faculty/{id}")
	public Faculty updateFaculty(
			@PathVariable("id") Integer id,
			@RequestBody Faculty newFaculty) {
		Faculty faculty = facultyRepository.findById(id).get();
		faculty.set(newFaculty);
		return facultyRepository.save(faculty);
	}
}
