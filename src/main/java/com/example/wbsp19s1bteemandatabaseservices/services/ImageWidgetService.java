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

import com.example.wbsp19s1bteemandatabaseservices.model.ImageWidget;
import com.example.wbsp19s1bteemandatabaseservices.model.Widget;
import com.example.wbsp19s1bteemandatabaseservices.repositories.ImageWidgetRepository;
import com.example.wbsp19s1bteemandatabaseservices.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ImageWidgetService {

	@Autowired
	ImageWidgetRepository imageWidgetRepository;
	@Autowired
	TopicRepository topicRepository;
	
	@PostMapping("/api/topics/{tid}/image/widget")
	public Widget createWidget(
			@PathVariable("tid") Integer tid,
			@RequestBody ImageWidget widget) {
		widget.setTopic(topicRepository.findById(tid).get());
		return imageWidgetRepository.save(widget);
	}
	
	@GetMapping("/api/image/widget/{wid}")
	public ImageWidget findImageWidgetById(
			@PathVariable("wid") Integer wid) {
		return imageWidgetRepository.findById(wid).get();
	}
	
	@PutMapping("/api/image/widget/{wid}")
	public ImageWidget updateImageWidget(
			@PathVariable("wid") Integer wid,
			@RequestBody ImageWidget newImageWidget) {
		ImageWidget imageWidget = imageWidgetRepository.findById(wid).get();
		imageWidget.set(newImageWidget);
		return imageWidgetRepository.save(imageWidget);
	}
	
	@DeleteMapping("/api/image/widget/{wid}")
	public void deleteImageWidget(
			@PathVariable("wid") Integer wid) {
		imageWidgetRepository.deleteById(wid);
	}
}
