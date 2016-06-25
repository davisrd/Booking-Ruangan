package com.websystique.springmvc.dao;

import com.leftproject.model.User;

public interface UserDao {
	
//	List<User> getUserKasubagTU(char userType);
//	List<User> getUserPengelolaKhusus(char userType);
//	void getUserDirektur(char userType);
	User getUser(String userCode);
	
	User findById(String code);
	
	User findByName(String name);

	User Login(String username, String password);
	
}
