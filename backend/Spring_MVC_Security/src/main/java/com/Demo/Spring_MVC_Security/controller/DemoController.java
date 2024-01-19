package com.Demo.Spring_MVC_Security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.Spring_MVC_Security.Entity.User;
import com.Demo.Spring_MVC_Security.Repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DemoController {
	
	private final UserRepository userRepository;
	
	public DemoController (UserRepository userRepository) {
		this.userRepository = userRepository;}
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
