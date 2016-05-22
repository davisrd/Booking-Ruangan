package com.websystique.springmvc.dao;

import java.util.List;

import com.leftproject.model.Rent;
import com.websystique.springmvc.model.*;


public interface RentDao {
	String cancelRent(Rent rent);
		
//	List<Rent> getAllRentUnacceptedByDirectur();
	
	List<Rent> getProposedRent();

	Rent getRent(int rentId);
	
	void deleteRentById(int id);
	
	void setRentPhase(Rent rent);
	
	void saveRent(Rent rent);
	
	boolean updateRent(Rent rent);
}
