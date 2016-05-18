package com.websystique.springmvc.dao;

import java.util.List;
import com.leftproject.model.Rent;


public interface RentDao {
	String cancelRent(Rent rent);
		
	List<Rent> getAllRentUnacceptedByDirectur();
	
	void setRentPhase(Rent rent);
	
	void saveRent(Rent rent);
	
	boolean updateRent(Rent rent);
}
