package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Rent;

public interface RentService {

	void saveRent(Rent rent);
	
	//void updateReservation(Reservation employee);
	
	void deleteRentById(int rentId);

//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	Rent getRent(int rentId);
	
	List<Rent> getProposedRent();
	
	void updateRent(Rent rent);
	
//	void sendMemorandum (String memorandum);
	
	
}
