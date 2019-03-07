package com.example.wbsp19s1bteemandatabaseservices.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget {

	@Id
	@GeneratedValue
		(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ManyToOne()
	@JsonIgnore
	private Topic topic;
	
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
		if(!topic.getWidgets().contains(this)) {
			topic.getWidgets().add(this);
		}
	}
	
	public void set(Widget newWidget) {
		this.title = newWidget.title;
		this.topic = newWidget.topic;
	}
}
