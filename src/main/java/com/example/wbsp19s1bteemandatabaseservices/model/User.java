package com.example.wbsp19s1bteemandatabaseservices.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue
		(strategy=GenerationType.IDENTITY)
	private Integer id;
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String role;
	
	@OneToMany(mappedBy="author")
	private List<Course> authoredCourses;
	
	public User() {
		this.authoredCourses = new ArrayList<>();
	}
	public User(String username, String password, String firstName, String lastName, String role) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.authoredCourses = new ArrayList<>();
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public void set(User newUser) {
		this.username = newUser.username;
		this.password = newUser.password;
		this.firstName = newUser.firstName;
		this.lastName = newUser.lastName;
		this.role = newUser.role;
	}
}
