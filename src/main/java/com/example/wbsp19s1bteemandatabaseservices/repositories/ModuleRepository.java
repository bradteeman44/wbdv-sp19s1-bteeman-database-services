package com.example.wbsp19s1bteemandatabaseservices.repositories;
import org.springframework.data.repository.*;
import com.example.wbsp19s1bteemandatabaseservices.model.Module;

public interface ModuleRepository 
	extends CrudRepository<Module, Integer>{}
