package com.example.wbsp19s1bteemandatabaseservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemandatabaseservices.model.Course;
import com.example.wbsp19s1bteemandatabaseservices.model.Faculty;
import com.example.wbsp19s1bteemandatabaseservices.repositories.*;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	FacultyRepository facultyRepository;
	
	@PostMapping("/api/faculty/{id}/courses")
	public Course createCourse(
			@PathVariable("id") Integer id,
			@RequestBody Course course) {
		course.setAuthor(facultyRepository.findById(id).get());
		return courseRepository.save(course);
	}
	
	@GetMapping("/api/faculty/{id}/courses")
	public List<Course> findAllCourses(
			@PathVariable("id") Integer id) {
		Faculty faculty = facultyRepository.findById(id).get();
		return faculty.getAuthoredCourses();
	}
	
	@GetMapping("/api/courses/{cid}")
	public Course findCourseById(
			@PathVariable("cid") Integer cid) {
		return courseRepository.findById(cid).get();
	}
	
	@PutMapping("/api/courses/{cid}")
	public Course updateCourse(
			@PathVariable("cid") Integer cid,
			@RequestBody Course newCourse) {
		Course course = courseRepository.findById(cid).get();
		course.set(newCourse);
		return courseRepository.save(course);
	}
	
	@DeleteMapping("/api/courses/{cid}")
	public void deleteCourse(
			@PathVariable("cid") Integer cid) {
		courseRepository.deleteById(cid);
	}
}