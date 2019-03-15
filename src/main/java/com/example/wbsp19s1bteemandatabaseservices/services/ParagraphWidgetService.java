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

import com.example.wbsp19s1bteemandatabaseservices.model.ParagraphWidget;
import com.example.wbsp19s1bteemandatabaseservices.model.Widget;
import com.example.wbsp19s1bteemandatabaseservices.repositories.ParagraphWidgetRepository;
import com.example.wbsp19s1bteemandatabaseservices.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ParagraphWidgetService {

	@Autowired
	ParagraphWidgetRepository paragraphWidgetRepository;
	@Autowired
	TopicRepository topicRepository;
	
	@PostMapping("/api/topics/{tid}/paragraph/widget")
	public Widget createWidget(
			@PathVariable("tid") Integer tid,
			@RequestBody ParagraphWidget widget) {
		widget.setTopic(topicRepository.findById(tid).get());
		return paragraphWidgetRepository.save(widget);
	}
	
	@GetMapping("/api/paragraph/widget/{wid}")
	public ParagraphWidget findParagraphWidgetById(
			@PathVariable("wid") Integer wid) {
		return paragraphWidgetRepository.findById(wid).get();
	}
	
	@PutMapping("/api/paragraph/widget/{wid}")
	public ParagraphWidget updateParagraphWidget(
			@PathVariable("wid") Integer wid,
			@RequestBody ParagraphWidget newParagraphWidget) {
		ParagraphWidget paragraphWidget = paragraphWidgetRepository.findById(wid).get();
		paragraphWidget.set(newParagraphWidget);
		return paragraphWidgetRepository.save(paragraphWidget);
	}
	
	@DeleteMapping("/api/paragraph/widget/{wid}")
	public void deleteParagraphWidget(
			@PathVariable("wid") Integer wid) {
		paragraphWidgetRepository.deleteById(wid);
	}
}
