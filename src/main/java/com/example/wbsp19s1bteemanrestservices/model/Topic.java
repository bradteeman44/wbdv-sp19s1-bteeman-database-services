package com.example.wbsp19s1bteemanrestservices.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {

	private Integer id;
	private String title;
	private List<Widget> widgets;
	
	public Topic() {}
	
	public Topic(int id, String title, List<Widget> widgets) {
		this.id = id;
		this.title = title;
		this.widgets = new ArrayList<>();
		this.widgets.addAll(widgets);
	}
	
	public Topic(int id, String title) {
		this.id = id;
		this.title = title;
		this.widgets = new ArrayList<>();
	}
	
	public void addWidget (Widget l) {
		this.widgets.add(l);
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

	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}
}
