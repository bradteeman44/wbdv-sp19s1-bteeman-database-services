package com.example.wbsp19s1bteemandatabaseservices.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lesson {

	@Id
	@GeneratedValue
		(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@OneToMany(mappedBy="lesson")
	private List<Topic> topics;
	
	@ManyToOne()
	@JsonIgnore
	private Module module;
	
	public Lesson() {
		this.topics = new ArrayList<>();
	}
	
	public Lesson(String title) {
		this.title = title;
		this.topics = new ArrayList<>();
		this.addTopic(new Topic("New Topic"));
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

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
		if(!module.getLessons().contains(this)) {
			module.getLessons().add(this);
		}
	}
	
	public void addTopic(Topic topic) {
		this.topics.add(topic);
		if(topic.getLesson() != this) {
			topic.setLesson(this);
		}
	}
	
	public void set(Lesson newLesson) {
		this.title = newLesson.title;
		this.topics = newLesson.topics;
		this.module = newLesson.module;
	}
}
