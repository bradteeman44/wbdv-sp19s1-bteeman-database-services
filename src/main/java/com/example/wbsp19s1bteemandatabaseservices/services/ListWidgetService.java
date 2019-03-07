package com.example.wbsp19s1bteemandatabaseservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.wbsp19s1bteemandatabaseservices.model.ListWidget;
import com.example.wbsp19s1bteemandatabaseservices.repositories.ListWidgetRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ListWidgetService {

	@Autowired
	ListWidgetRepository listWidgetRepository;
	
	@GetMapping("/api/list/widget/{wid}")
	public ListWidget findListWidgetById(
			@PathVariable("wid") Integer wid) {
		return listWidgetRepository.findById(wid).get();
	}
	
	@PutMapping("/api/list/widget/{wid}")
	public ListWidget updateListWidget(
			@PathVariable("wid") Integer wid,
			@RequestBody ListWidget newListWidget) {
		ListWidget listWidget = listWidgetRepository.findById(wid).get();
		listWidget.set(newListWidget);
		return listWidgetRepository.save(listWidget);
	}
	
	@DeleteMapping("/api/list/widget/{wid}")
	public void deleteListWidget(
			@PathVariable("wid") Integer wid) {
		listWidgetRepository.deleteById(wid);
	}
}
