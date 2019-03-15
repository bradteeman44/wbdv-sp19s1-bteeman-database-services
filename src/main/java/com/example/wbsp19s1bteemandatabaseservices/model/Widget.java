package com.example.wbsp19s1bteemandatabaseservices.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget {

	@Id
	@GeneratedValue
		(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected String wtype;
	protected Integer width;
	protected Integer height;
	protected Boolean editing;
	protected String title;
	
	@ManyToOne()
	@JsonIgnore
	protected Topic topic;
	
	public Widget() {
		this.wtype = "HEADING";
		this.width = 100;
		this.height = 100;
		this.editing = false;
		this.title = "New Widget";
	}
	
	public Widget(String wtype, Integer width, Integer height, Boolean editing, String title) {
		this.wtype = wtype;
		this.width = width;
		this.height = height;
		this.editing = editing;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	
	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public Boolean getEditing() {
		return editing;
	}

	public void setEditing(Boolean editing) {
		this.editing = editing;
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
		this.wtype = newWidget.wtype;
		this.width = newWidget.width;
		this.height = newWidget.height;
		this.editing = newWidget.editing;
		this.title = newWidget.title;
	}
}
