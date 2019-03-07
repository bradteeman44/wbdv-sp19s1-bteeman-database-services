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

import com.example.wbsp19s1bteemandatabaseservices.model.Module;
import com.example.wbsp19s1bteemandatabaseservices.repositories.*;
import com.example.wbsp19s1bteemandatabaseservices.model.Lesson;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class LessonService {

	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	ModuleRepository moduleRepository;
	
	@PostMapping("/api/modules/{mid}/lessons")
	public Lesson createLesson(
			@PathVariable("mid") Integer mid,
			@RequestBody Lesson lesson) {
		lesson.setModule(moduleRepository.findById(mid).get());
		return lessonRepository.save(lesson);
	}
	
	@GetMapping("/api/modules/{mid}/lessons")
	public List<Lesson> findAllLessons(
			@PathVariable("mid") Integer mid) {
		Module module = moduleRepository.findById(mid).get();
		return module.getLessons();
	}
	
	@GetMapping("/api/lessons/{lid}")
	public Lesson findLessonById(
			@PathVariable("lid") Integer lid) {
		return lessonRepository.findById(lid).get();
	}
	
	@PutMapping("/api/lessons/{lid}")
	public Lesson updateLesson(
			@PathVariable("lid") Integer lid,
			@RequestBody Lesson newLesson) {
		Lesson lesson = lessonRepository.findById(lid).get();
		lesson.set(newLesson);
		return lessonRepository.save(lesson);
	}
	
	@DeleteMapping("/api/lessons/{lid}")
	public void deleteLesson(
			@PathVariable("lid") Integer lid) {
		lessonRepository.deleteById(lid);
	}
}
