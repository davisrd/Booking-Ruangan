package com.leftproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.leftproject.model.User;
import com.leftproject.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestParam("userCode") String userCode, @RequestParam("password") String password) {
    	User user = userService.Login(userCode, password);
    	if(user != null){
	        return new ResponseEntity<User>(user, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    	}
    }
}
