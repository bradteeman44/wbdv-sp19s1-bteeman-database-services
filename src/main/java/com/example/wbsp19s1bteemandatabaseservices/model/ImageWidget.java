package com.example.wbsp19s1bteemandatabaseservices.model;

import javax.persistence.*;

@Entity
public class ImageWidget extends Widget {

	private String url;
	
	public ImageWidget() {}
	
	public ImageWidget(String wtype, Integer width, Integer height, 
			Boolean editing, String title, String url) {
		this.wtype = wtype;
		this.width = width;
		this.height = height;
		this.editing = editing;
		this.title = title;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void set(ImageWidget newHImageWidget) {
		this.wtype = newHImageWidget.wtype;
		this.width = newHImageWidget.width;
		this.height = newHImageWidget.height;
		this.editing = newHImageWidget.editing;
		this.title = newHImageWidget.title;
		this.url = newHImageWidget.url;
	}
}
