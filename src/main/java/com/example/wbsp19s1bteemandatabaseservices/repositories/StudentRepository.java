package com.example.wbsp19s1bteemandatabaseservices.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.wbsp19s1bteemandatabaseservices.model.*;

public interface StudentRepository 
	extends CrudRepository<Student, Integer>{}
