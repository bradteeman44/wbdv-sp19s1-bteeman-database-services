package com.example.wbsp19s1bteemandatabaseservices.services;

import java.util.ArrayList;
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
	
	private User alice = new User("alice", "p", "Alice", "Wonderland", "STUDENT");
	private User bob   = new User("bob", "p","Bob", "Marley", "ADMIN");
	private List<User> users = new ArrayList<User>();
	{
		users.add(alice);
		users.add(bob);
	}
	
	@PostMapping("/api/users")
	public User createUser(@RequestBody User user) {
	  		return userRepository.save(user);
	}

	@PostMapping("/api/register")
	public User register(@RequestBody User user,
			HttpSession session) {
		user.setId(((Double)(Math.random() * 10000000)).intValue());
		session.setAttribute("currentUser", user);
		users.add(user);
		return user;
	}
	
	@PostMapping("/api/profile")
	public User profile(HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		return currentUser;
	}
	
	@PostMapping("/api/login")
	public User login(@RequestBody User credentials,
			HttpSession session) {
		for (User user : users) {
			if( user.getUsername().equals(credentials.getUsername()) 
					&& user.getPassword().equals(credentials.getPassword())) {
				session.setAttribute("currentUser", user);
				return user;
			}
		}
		return null;
	}
	
	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
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
