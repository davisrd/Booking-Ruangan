package com.websystique.springmvc.dao;

import java.util.List;

import com.leftproject.model.Rent;
import com.leftproject.model.User;


public interface RentDao {
	boolean cancelRent(Rent rent);
		
//	List<Rent> getAllRentUnacceptedByDirectur();
	
//	List<Rent> getProposedRent();

//	Rent getRent(int rentId);
	
//	void deleteRentById(int id);
	
	List<Rent> getNotYetApproveMovementRentByDirectur();
	
	boolean setRentPhase(Rent rent, String phase);
	
	boolean saveRent(Rent rent);
	
	boolean updateRent(Rent rent);
	
	List<Rent> getAllMinRent(User user);
	
	public List<Rent> getAllRentsByUser(User user);
	
	public List<Rent> getProposedRent();
	
	public Rent getRentByCode(String rentCode);
	
	
}