package com.example.wbsp19s1bteemandatabaseservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemandatabaseservices.model.HeadingWidget;
import com.example.wbsp19s1bteemandatabaseservices.model.Widget;
import com.example.wbsp19s1bteemandatabaseservices.repositories.HeadingWidgetRepository;
import com.example.wbsp19s1bteemandatabaseservices.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class HeadingWidgetService {

	@Autowired
	HeadingWidgetRepository headingWidgetRepository;
	@Autowired
	TopicRepository topicRepository;
	
	@PostMapping("/api/topics/{tid}/heading/widget")
	public Widget createWidget(
			@PathVariable("tid") Integer tid,
			@RequestBody HeadingWidget widget) {
		widget.setTopic(topicRepository.findById(tid).get());
		return headingWidgetRepository.save(widget);
	}
	
	@GetMapping("/api/heading/widget/{wid}")
	public HeadingWidget findHeadingWidgetById(
			@PathVariable("wid") Integer wid) {
		return headingWidgetRepository.findById(wid).get();
	}
	
	@PutMapping("/api/heading/widget/{wid}")
	public HeadingWidget updateHeadingWidget(
			@PathVariable("wid") Integer wid,
			@RequestBody HeadingWidget newHeadingWidget) {
		HeadingWidget headingWidget = headingWidgetRepository.findById(wid).get();
		headingWidget.set(newHeadingWidget);
		return headingWidgetRepository.save(headingWidget);
	}
	
	@DeleteMapping("/api/heading/widget/{wid}")
	public void deleteHeadingWidget(
			@PathVariable("wid") Integer wid) {
		headingWidgetRepository.deleteById(wid);
	}
}
