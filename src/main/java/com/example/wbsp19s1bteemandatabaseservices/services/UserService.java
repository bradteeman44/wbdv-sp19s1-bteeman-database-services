package com.example.wbsp19s1bteemandatabaseservices.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemandatabaseservices.model.User;
import com.example.wbsp19s1bteemandatabaseservices.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")

public class UserService {
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/api/register")
	public User register(@RequestBody User user,
			HttpSession session) {
		session.setAttribute("currentUser", user);
		return userRepository.save(user);
	}
	
	@PostMapping("/api/profile")
	public User profile(HttpSession session) {
		User currentUser = (User)session.getAttribute("currentUser");
		return currentUser;
	}
	
	@PostMapping("/api/login")
	public User login(@RequestBody User credentials,
			HttpSession session) {
		User user = userRepository.findUserByCredentials(credentials.getUsername(), credentials.getPassword());
		session.setAttribute("currentUser", user);
		return user;
	}
	
	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@PostMapping("/api/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/api/users")
	public List<User> findAllUsers(
			@RequestParam(name="username", required=false) String uname) {  
		if(uname != null) {
			return userRepository.
	           findUserByUsername(uname); }
	   return (List<User>) userRepository.findAll();
	}

	@GetMapping("/api/users/{id}")
	public User findUserById(
			@PathVariable("id") Integer id) {
		return userRepository.findById(id).get();
	}
	
	@PutMapping("/api/users/{id}")
	public User updateUser(
			@PathVariable("id") int id,
			@RequestBody User newUser) {
		User user = userRepository.findById(id).get();
		user.set(newUser);
		return userRepository.save(user);
	}
	
	@DeleteMapping("/api/users/{id}")
	public void deleteUser(
			@PathVariable("id") int id) {
		userRepository.deleteById(id);
	}
}
