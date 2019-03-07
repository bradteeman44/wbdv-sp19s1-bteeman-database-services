package com.example.wbsp19s1bteemandatabaseservices.model;

import javax.persistence.*;

@Entity
public class ListWidget extends Widget {

	private String list;
	private String text;
	
	public ListWidget() {}
	
	public ListWidget(String wtype, Integer width, Integer height, 
			Boolean editing, String title, String list, String text) {
		this.wtype = wtype;
		this.width = width;
		this.height = height;
		this.editing = editing;
		this.title = title;
		this.list = list;
		this.text = text;
	}

	public String getList() {
		return list;
	}

	public void setSize(String list) {
		this.list = list;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void set(ListWidget newListWidget) {
		this.wtype = newListWidget.wtype;
		this.width = newListWidget.width;
		this.height = newListWidget.height;
		this.topic = newListWidget.topic;
		this.editing = newListWidget.editing;
		this.title = newListWidget.title;
		this.list = newListWidget.list;
		this.text = newListWidget.text;
	}
}
