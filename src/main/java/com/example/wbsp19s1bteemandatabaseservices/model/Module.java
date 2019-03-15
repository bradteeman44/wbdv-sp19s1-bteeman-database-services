package com.example.wbsp19s1bteemandatabaseservices.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="modules")
public class Module {

	@Id
	@GeneratedValue
		(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@OneToMany(mappedBy="module")
	private List<Lesson> lessons;
	
	@ManyToOne()
	@JsonIgnore
	private Course course;
	
	public Module() {
		this.lessons = new ArrayList<>();
	}
	
	public Module(String title) {
		this.title = title;
		this.lessons = new ArrayList<>();
		this.addLesson(new Lesson("New Lesson"));
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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
		if(!course.getModules().contains(this)) {
			course.getModules().add(this);
		}
	}
	
	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
		if(lesson.getModule() != this) {
			lesson.setModule(this);
		}
	}
	
	public void set(Module newModule) {
		this.title = newModule.title;
	}
}
