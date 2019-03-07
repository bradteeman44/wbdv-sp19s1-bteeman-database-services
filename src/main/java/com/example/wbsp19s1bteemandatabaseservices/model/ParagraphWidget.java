package com.example.wbsp19s1bteemandatabaseservices.model;

import javax.persistence.*;

@Entity
public class ParagraphWidget extends Widget {

	private String text;
	
	public ParagraphWidget() {}
	
	public ParagraphWidget(String wtype, Integer width, Integer height, 
			Boolean editing, String title, String text) {
		this.wtype = wtype;
		this.width = width;
		this.height = height;
		this.editing = editing;
		this.title = title;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void set(ParagraphWidget newParagraphWidget) {
		this.wtype = newParagraphWidget.wtype;
		this.width = newParagraphWidget.width;
		this.height = newParagraphWidget.height;
		this.topic = newParagraphWidget.topic;
		this.editing = newParagraphWidget.editing;
		this.title = newParagraphWidget.title;
		this.text = newParagraphWidget.text;
	}
}
