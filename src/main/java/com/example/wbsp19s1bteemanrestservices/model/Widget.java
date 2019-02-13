package com.example.wbsp19s1bteemanrestservices.model;

public class Widget {

	private Integer id;
	private String title;
	
	public Widget() {}
	
	public Widget(int id, String title) {
		this.id = id;
		this.title = title;
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
}
