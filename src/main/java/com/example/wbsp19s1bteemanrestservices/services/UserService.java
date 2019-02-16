package com.example.wbsp19s1bteemanrestservices.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbsp19s1bteemanrestservices.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserService {
	
	private User alice = new User(123, "alice", "p", "Alice", "Wonderland", "STUDENT");
	private User bob   = new User(234, "bob", "p","Bob", "Marley", "ADMIN");
	private List<User> users = new ArrayList<User>();
	{
		users.add(alice);
		users.add(bob);
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
	public List<User> findAllUsers() {
		return users;
	}
	
	@GetMapping("/api/users/{id}")
	public User findUserById(
			@PathVariable("id") Integer id) {
		for (User user : users) {
			if( user.getId().intValue() == id) {
				return user;
			}
		}
		return null;
	}
}
