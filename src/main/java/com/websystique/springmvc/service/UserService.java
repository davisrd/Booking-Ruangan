package com.websystique.springmvc.service;

import com.leftproject.model.User;

public interface UserService {

	User findById(String id);
	
	User findByName(String name);
	
}