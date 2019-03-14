package com.example.wbsp19s1bteemandatabaseservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.wbsp19s1bteemandatabaseservices.model.Lesson;
import com.example.wbsp19s1bteemandatabaseservices.model.Topic;
import com.example.wbsp19s1bteemandatabaseservices.repositories.*;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	LessonRepository lessonRepository;
	
	@PostMapping("/api/lessons/{lid}/topics")
	public Topic createTopic(
			@PathVariable("lid") Integer lid,
			@RequestBody Topic topic) {
		topic.setLesson(lessonRepository.findById(lid).get());
		return topicRepository.save(topic);
	}
	
	@GetMapping("/api/lessons/{lid}/topics")
	public List<Topic> findAllTopics(
			@PathVariable("lid") Integer lid) {
		Lesson lesson = lessonRepository.findById(lid).get();
		return lesson.getTopics();
	}
	
	@GetMapping("/api/topics/{tid}")
	public Topic findTopicById(
			@PathVariable("tid") Integer tid) {
		return topicRepository.findById(tid).get();
	}
	
	@PutMapping("/api/topics/{tid}")
	public Topic updateTopic(
			@PathVariable("tid") Integer tid,
			@RequestBody Topic newTopic) {
		Topic topic = topicRepository.findById(tid).get();
		topic.set(newTopic);
		return topicRepository.save(topic);
	}
	
	@DeleteMapping("/api/topics/{tid}")
	public void deleteTopic(
			@PathVariable("tid") Integer tid) {
		topicRepository.deleteById(tid);
	}
}
