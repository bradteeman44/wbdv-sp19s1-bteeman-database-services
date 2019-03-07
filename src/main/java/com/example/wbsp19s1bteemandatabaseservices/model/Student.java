package com.example.wbsp19s1bteemandatabaseservices.model;

import javax.persistence.Entity;

@Entity
public class Student extends User {

	private float gpa;
	private int gradYear;
	
	public Student() {}
	public Student(String username, String password, String firstName, String lastName, 
			String role, float gpa, int gradYear) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.gpa = gpa;
		this.gradYear = gradYear;	
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public int getGradYear() {
		return gradYear;
	}
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
}
