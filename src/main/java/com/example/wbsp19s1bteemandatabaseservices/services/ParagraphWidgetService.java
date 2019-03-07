package com.example.wbsp19s1bteemandatabaseservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.wbsp19s1bteemandatabaseservices.model.ParagraphWidget;
import com.example.wbsp19s1bteemandatabaseservices.repositories.ParagraphWidgetRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ParagraphWidgetService {

	@Autowired
	ParagraphWidgetRepository paragraphWidgetRepository;
	
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
