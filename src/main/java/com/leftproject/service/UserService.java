package com.leftproject.service;

import com.leftproject.model.User;

public interface UserService {

	User findById(String id);
	
	User findByName(String name);

	User Login(String username, String password);
	
}