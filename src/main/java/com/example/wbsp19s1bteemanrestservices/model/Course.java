package com.example.wbsp19s1bteemanrestservices.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private Integer id;
	private String title;
	private List<Module> modules;
	
	public Course() {}
	
	public Course(int id, String title, List<Module> modules) {
		this.id = id;
		this.title = title;
		this.modules = new ArrayList<>();
		this.modules.addAll(modules);
	}
	
	public Course(int id, String title) {
		this.id = id;
		this.title = title;
		this.modules = new ArrayList<>();
	}
	
	public void addModule (Module l) {
		this.modules.add(l);
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
}
