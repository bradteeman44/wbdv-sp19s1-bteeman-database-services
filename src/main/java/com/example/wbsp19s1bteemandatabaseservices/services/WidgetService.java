package com.example.wbsp19s1bteemandatabaseservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemandatabaseservices.model.Widget;
import com.example.wbsp19s1bteemandatabaseservices.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class WidgetService {

	@Autowired
	WidgetRepository widgetRepository;
	
	@GetMapping("/api/widget/{wid}")
	public Widget findWidgetById(
			@PathVariable("wid") Integer wid) {
		return widgetRepository.findById(wid).get();
	}
	
	@PutMapping("/api/widget/{wid}")
	public Widget updateWidget(
			@PathVariable("wid") Integer wid,
			@RequestBody Widget newWidget) {
		Widget widget = widgetRepository.findById(wid).get();
		widget.set(newWidget);
		return widgetRepository.save(widget);
	}
	
	@DeleteMapping("/api/widgte/{wid}")
	public void deleteWidget(
			@PathVariable("wid") Integer wid) {
		widgetRepository.deleteById(wid);
	}
}
