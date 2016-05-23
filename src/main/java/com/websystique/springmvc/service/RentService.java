package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Rent;

public interface RentService {

	void saveRent(Rent rent);
	
	//void updateReservation(Reservation employee);
	
	void deleteRentByCode(String rentCode);

//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	Rent getRentByCode(String rentCode);
	
	List<Rent> getProposedRent();
	
	void updateRent(Rent rent);
	
//	void sendMemorandum (String memorandum);
	
	
}
