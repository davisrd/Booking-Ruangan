package com.websystique.springmvc.dao;

import java.util.List;

import com.leftproject.model.Rent;
import com.websystique.springmvc.model.*;
import com.leftproject.model.User;


public interface RentDao {
	String cancelRent(Rent rent);
		
//	List<Rent> getAllRentUnacceptedByDirectur();
	
	List<Rent> getProposedRent();

	Rent getRent(int rentId);
	
	void deleteRentById(int id);
	
	List<Rent> getNotYetApproveMovementRentByDirectur();
	
	String setRentPhase(Rent rent, char phase);
	
	boolean saveRent(Rent rent);
	
	boolean updateRent(Rent rent);
	
	void getAllMinRent(User user);
	
	public List<Rent> getAllRentsByUser(User user);
}
