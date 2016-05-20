package com.websystique.springmvc.dao;

import java.util.List;
import com.leftproject.model.Rent;
import com.leftproject.model.User;


public interface RentDao {
	String cancelRent(Rent rent);
		
	List<Rent> getNotYetApproveMovementRentByDirectur();
	
	void setRentPhase(Rent rent);
	
	boolean saveRent(Rent rent);
	
	boolean updateRent(Rent rent);
	
	void getAllMinRent(User user);
	
	public List<Rent> getAllRentsByUser(User user);
}
