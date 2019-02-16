package com.example.wbsp19s1bteemanrestservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemanrestservices.services.LessonService;
import com.example.wbsp19s1bteemanrestservices.model.Lesson;
import com.example.wbsp19s1bteemanrestservices.model.Topic;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class TopicService {
	
	private Topic one = new Topic(123, "Topic 1");
	private Topic two = new Topic(234, "Topic 2");
	private List<Topic> topics = new ArrayList<Topic>();
	{
		topics.add(one);
		topics.add(two);
	}
	
	@PostMapping("/api/lessons/{lid}/topics")
	public List<Topic> createTopic(
			@PathVariable("lid") Integer lid,
			@RequestBody Topic topic) {
		topic.setId(((Double)(Math.random() * 10000000)).intValue());
		for(Lesson les : LessonService.lessons) {
			if(les.getId().intValue() == lid) {
				les.addTopic(topic);;
				topics.add(topic);
				return les.getTopics();
			}
		}
		return null;
	}
	
	@GetMapping("/api/lessons/{lid}/topics")
	public List<Topic> findAllTopics(
			@PathVariable("lid") Integer lid) {
		for(Lesson les : LessonService.lessons) {
			if(les.getId().intValue() == lid) {
				return les.getTopics();
			}
		}
		return null;
	}
	
	@GetMapping("/api/topics/{tid}")
	public Topic findTopicById(
			@PathVariable("tid") Integer tid) {
		for(Topic top : topics) {
			if(top.getId().intValue() == tid) {
				return top;
			}
		}
		return null;
	}
	
	@PutMapping("/api/topics/{tid}")
	public Topic updateTopic(
			@PathVariable("tid") Integer tid,
			@RequestBody Topic topic) {
		for(Topic top : topics) {
			if(top.getId().intValue() == tid) {
				top.setTitle(topic.getTitle());
				top.setWidgets(topic.getWidgets());
				return top;
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/topics/{tid}")
	public List<Topic> deleteTopic(
			@PathVariable("tid") Integer tid) {
		topics = topics.stream()
				.filter(topic -> topic.getId().intValue() != tid)
			    .collect(Collectors.toList());
		return topics;
	}

}
