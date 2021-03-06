package com.leftproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leftproject.dao.UserDao;
import com.leftproject.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(String code) {
		return dao.findById(code);
	}

	public User findByName(String name) {
		return dao.findByName(name);
	}

	public User Login(String userCode, String password){
		return dao.Login(userCode, password);
	}
	

}
