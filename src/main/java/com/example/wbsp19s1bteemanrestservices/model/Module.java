package com.example.wbsp19s1bteemanrestservices.model;

import java.util.ArrayList;
import java.util.List;

public class Module {

	private Integer id;
	private String title;
	private List<Lesson> lessons;
	
	public Module() {}
	
	public Module(int id, String title, List<Lesson> lessons) {
		this.id = id;
		this.title = title;
		this.lessons = new ArrayList<>();
		this.lessons.addAll(lessons);
	}
	
	public Module(int id, String title) {
		this.id = id;
		this.title = title;
		this.lessons = new ArrayList<>();
	}
	
	public void addLesson (Lesson l) {
		this.lessons.add(l);
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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}
