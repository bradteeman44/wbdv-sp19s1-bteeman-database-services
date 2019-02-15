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

import com.example.wbsp19s1bteemanrestservices.model.Module;
import com.example.wbsp19s1bteemanrestservices.model.Topic;
import com.example.wbsp19s1bteemanrestservices.model.Widget;
import com.example.wbsp19s1bteemanrestservices.model.Course;
import com.example.wbsp19s1bteemanrestservices.model.Lesson;
import com.example.wbsp19s1bteemanrestservices.services.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ModuleService {

	private Module one = new Module(1, "Module 1");
	private Module two = new Module(2, "Module 2");
	
	private Widget wid1 = new Widget(1, "The DOM");
	private Widget wid2 = new Widget(2, "The Wid");
	private Topic top1 = new Topic(1, "The Wid");
	private Topic top2 = new Topic(2, "The Wid");
	private Lesson les1 = new Lesson(1, "The Wid");
	private Lesson les2 = new Lesson(2, "The Wid");
	
	public static List<Module> modules = new ArrayList<Module>();
	/*
	{
		top1.addWidget(wid1);
		les1.addTopic(top1);
		one.addLesson(les1);
		modules.add(one);
	}
	*/
	@PostMapping("/api/courses/{cid}/modules")
	public List<Module> createModule(
			@PathVariable("cid") Integer cid,
			@RequestBody Module module) {
		module.setId(((Double)(Math.random() * 10000000)).intValue());
		for(Course cor : CourseService.courses) {
			if(cor.getId().intValue() == cid) {
				cor.addModule(module);
				modules.add(module);
				return cor.getModules();
			}
		}
		return null;
	}
	
	@GetMapping("/api/courses/{cid}/modules")
	public List<Module> findAllModules(
			@PathVariable("cid") Integer cid) {
		for(Course cor : CourseService.courses) {
			if(cor.getId().intValue() == cid) {
				return cor.getModules();
			}
		}
		return null;
	}
	
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(
			@PathVariable("mid") Integer mid) {
		for(Module mod : modules) {
			if(mod.getId().intValue() == mid) {
				return mod;
			}
		}
		return null;
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(
			@PathVariable("mid") Integer mid,
			@RequestBody Module module) {
		for(Module mod : modules) {
			if(mod.getId().intValue() == mid) {
				mod.setTitle(module.getTitle());
				mod.setLessons(module.getLessons());
				return mod;
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/modules/{mid}")
	public List<Module> deleteModule(
			@PathVariable("mid") Integer mid) {
		modules = modules.stream()
				.filter(module -> module.getId().intValue() != mid)
			    .collect(Collectors.toList());
		return modules;
	}
}
