package com.prashant.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.user.domain.User;
import com.prashant.user.services.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user)
	{
		return userService.save(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable(value="id") Long userId)
	{
		return userService.getUser(userId);
	}

	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
}
