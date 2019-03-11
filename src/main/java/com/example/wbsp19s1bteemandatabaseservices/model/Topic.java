package com.example.wbsp19s1bteemandatabaseservices.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {

	@Id
	@GeneratedValue
		(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@OneToMany(mappedBy="topic")
	private List<Widget> widgets;
	
	@ManyToOne()
	@JsonIgnore
	private Lesson lesson;
	
	public Topic() {
		this.widgets = new ArrayList<>();
	}
	
	public Topic(String title) {
		this.title = title;
		this.widgets = new ArrayList<>();
		this.addWidget(new Widget());
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

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
		if(!lesson.getTopics().contains(this)) {
			lesson.getTopics().add(this);
		}
	}
	
	public void addWidget(Widget widget) {
		this.widgets.add(widget);
		if(widget.getTopic() != this) {
			widget.setTopic(this);
		}
	}
	
	public void set(Topic newTopic) {
		this.title = newTopic.title;
		this.widgets = newTopic.widgets;
		this.lesson = newTopic.lesson;
	}
	
}
