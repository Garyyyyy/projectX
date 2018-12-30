package com.projectX.AuthService.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectX.AuthService.model.User;
import com.projectX.AuthService.model.UserDaoService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		//return service.findOne(id);
		return new User(1, "Adam", new Date());
	}
	
}
