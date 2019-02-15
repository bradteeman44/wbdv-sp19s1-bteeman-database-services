package com.example.wbsp19s1bteemanrestservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemanrestservices.model.Course;
import com.example.wbsp19s1bteemanrestservices.model.Lesson;
import com.example.wbsp19s1bteemanrestservices.model.Topic;
import com.example.wbsp19s1bteemanrestservices.model.Widget;
import com.example.wbsp19s1bteemanrestservices.model.Module;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseService {

	
	private Course one = new Course(123, "WebDev");
	private Widget wid1 = new Widget(1, "The DOM");
	private Widget wid2 = new Widget(2, "The Wid");
	private Topic top1 = new Topic(1, "The Wid");
	private Topic top2 = new Topic(2, "The Wid");
	private Lesson les1 = new Lesson(1, "The Wid");
	private Lesson les2 = new Lesson(2, "The Wid");
	private Module mod1 = new Module(1, "The Wid");
	private Module mod2 = new Module(2, "The Wid");
	
	
	
	private Course two = new Course(234, "Best Course");
	public static List<Course> courses = new ArrayList<Course>();
	/*
	{
		top1.addWidget(wid1);
		top1.addWidget(wid2);
		top2.addWidget(wid1);
		top2.addWidget(wid2);
		les1.addTopic(top1);
		les1.addTopic(top2);
		les2.addTopic(top1);
		les2.addTopic(top2);
		mod1.addLesson(les1);
		mod2.addLesson(les2);
		one.addModule(mod1);
		one.addModule(mod2);
		courses.add(one);
		courses.add(two);
	}
	*/
	
	@PostMapping("/api/courses")
	public List<Course> createCourse(
			@RequestBody Course course) {
		course.setId(((Double)(Math.random() * 10000000)).intValue());
		courses.add(course);
		return courses;
	}
	
	@GetMapping("/api/courses")
	public List<Course> findAllCourses() {
		return courses;
	}
	
	@GetMapping("/api/courses/{cid}")
	public Course findCourseById(
			@PathVariable("cid") Integer cid) {
		for(Course cor : courses) {
			if(cor.getId().intValue() == cid) {
				return cor;
			}
		}
		return null;
	}
	
	@PutMapping("/api/courses/{cid}")
	public Course updateCourse(
			@PathVariable("cid") Integer cid,
			@RequestBody Course course) {
		for(Course cor : courses) {
			if(cor.getId().intValue() == cid) {
				cor.setTitle(course.getTitle());
				cor.setModules(course.getModules());
				return cor;
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/courses/{cid}")
	public List<Course> deleteCourse(
			@PathVariable("cid") Integer cid) {
		courses = courses.stream()
				.filter(course -> course.getId().intValue() != cid)
			    .collect(Collectors.toList());
		return courses;
	}
}
