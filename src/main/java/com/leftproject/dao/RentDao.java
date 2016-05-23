package com.leftproject.dao;

import java.util.List;

import com.leftproject.model.Rent;
import com.leftproject.model.User;


public interface RentDao {
	String cancelRent(Rent rent);
		
//	List<Rent> getAllRentUnacceptedByDirectur();
	
	List<Rent> getProposedRent();

	Rent getRentByCode(String rentCode);
	
	void deleteRentByCode(String rentCode);
	
	List<Rent> getNotYetApproveMovementRentByDirectur();
	
	String setRentPhase(Rent rent, String phase);
	
	boolean saveRent(Rent rent);
	
	boolean updateRent(Rent rent);
	
	void getAllMinRent(User user);
	
	public List<Rent> getAllRentsByUser(User user);
}
