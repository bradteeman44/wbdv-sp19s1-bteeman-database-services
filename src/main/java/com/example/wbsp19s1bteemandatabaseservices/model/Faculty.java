package com.example.wbsp19s1bteemandatabaseservices.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Faculty extends User {

	private String office;
	private Boolean tenure;
	@OneToMany(mappedBy="author")
	private List<Course> authoredCourses;
	
	public Faculty() {
		this.authoredCourses = new ArrayList<>();
	}
	public Faculty(String username, String password, String firstName, String lastName, 
			String role, String office, Boolean tenure) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.office = office;
		this.tenure = tenure;
		this.authoredCourses = new ArrayList<>();
	}
	public Faculty(String username, String password) {
		this.username = username;
		this.password = password;
		this.authoredCourses = new ArrayList<>();
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenure() {
		return tenure;
	}
	public void setTenure(Boolean tenure) {
		this.tenure = tenure;
	}
	public void authoredCourse(Course course) {
		this.authoredCourses.add(course);
		if(course.getAuthor() != this) {
			course.setAuthor(this);
		}
	}
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}
	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}
	
	public void set(Faculty newFaculty) {
		this.username = newFaculty.username;
		this.password = newFaculty.password;
		this.firstName = newFaculty.firstName;
		this.lastName = newFaculty.lastName;
		this.role = newFaculty.role;
		this.office = newFaculty.office;
		this.tenure = newFaculty.tenure;
		this.authoredCourses = newFaculty.authoredCourses;
	}
}
