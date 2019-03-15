package com.example.wbsp19s1bteemandatabaseservices.model;

import javax.persistence.*;

@Entity
public class HeadingWidget extends Widget {
	
	private Integer size;
	private String text;
	
	public HeadingWidget() {}
	
	public HeadingWidget(String wtype, Integer width, Integer height, 
			Boolean editing, String title, Integer size, String text) {
		this.wtype = wtype;
		this.width = width;
		this.height = height;
		this.editing = editing;
		this.title = title;
		this.size = size;
		this.text = text;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void set(HeadingWidget newHeadingWidget) {
		this.wtype = newHeadingWidget.wtype;
		this.width = newHeadingWidget.width;
		this.height = newHeadingWidget.height;
		this.editing = newHeadingWidget.editing;
		this.title = newHeadingWidget.title;
		this.size = newHeadingWidget.size;
		this.text = newHeadingWidget.text;
	}
}
