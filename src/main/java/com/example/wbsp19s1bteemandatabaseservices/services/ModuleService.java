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
import com.example.wbsp19s1bteemandatabaseservices.model.Course;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ModuleService {

	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/api/courses/{cid}/modules")
	public Module createModule(
			@PathVariable("cid") Integer cid,
			@RequestBody Module module) {
		module.setCourse(courseRepository.findById(cid).get());
		return moduleRepository.save(module);
	}
	
	@GetMapping("/api/courses/{cid}/modules")
	public List<Module> findAllModules(
			@PathVariable("cid") Integer cid) {
		Course course = courseRepository.findById(cid).get();
		return course.getModules();
	}
	
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(
			@PathVariable("mid") Integer mid) {
		return moduleRepository.findById(mid).get();
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(
			@PathVariable("mid") Integer mid,
			@RequestBody Module newModule) {
		Module module = moduleRepository.findById(mid).get();
		module.set(newModule);
		return moduleRepository.save(module);
	}
	
	@DeleteMapping("/api/modules/{mid}")
	public void deleteModule(
			@PathVariable("mid") Integer mid) {
		moduleRepository.deleteById(mid);
	}
}
