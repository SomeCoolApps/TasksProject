package com.tasks.rest.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.module.model.User;

@RestController
public class UserController {
	
	   @RequestMapping("/")
	    public String welcome() {//Welcome page, non-rest
	        return "Welcome to RestTemplate Example.";
	    }
	 
	    @RequestMapping("/user/{player}")
	    public User message(@PathVariable String player) {//REST Endpoint.
	 
	        User user = new User(1,"Sunil");
	        return user;
	    }

}
