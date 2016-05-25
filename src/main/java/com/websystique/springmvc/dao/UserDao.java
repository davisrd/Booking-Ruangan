package com.websystique.springmvc.dao;



import java.util.List;

import com.leftproject.model.Rent;
import com.leftproject.model.Room;
import com.leftproject.model.User;

public interface UserDao {
	
//	List<User> getUserKasubagTU(char userType);
//	List<User> getUserPengelolaKhusus(char userType);
//	void getUserDirektur(char userType);
	User getUser(String userCode);
	

	
}
