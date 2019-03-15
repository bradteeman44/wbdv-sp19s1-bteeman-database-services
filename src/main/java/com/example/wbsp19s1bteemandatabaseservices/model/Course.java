package com.example.wbsp19s1bteemandatabaseservices.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@GeneratedValue
		(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@OneToMany(mappedBy="course")
	private List<Module> modules;
	
	@ManyToOne()
	@JsonIgnore
	private User author;
	
	public Course() {
		this.modules = new ArrayList<>();
	}
	
	public Course(String title) {
		this.title = title;
		this.modules = new ArrayList<>();
		this.addModule(new Module("New Module"));
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
		if(!author.getAuthoredCourses().contains(this)) {
			author.getAuthoredCourses().add(this);
		}
	}
	public void addModule(Module module) {
		this.modules.add(module);
		if(module.getCourse() != this) {
			module.setCourse(this);
		}
	}
	
	public void set(Course newCourse) {
		this.title = newCourse.title;
	}
}
