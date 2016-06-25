package com.leftproject.service;

import java.util.List;

import com.leftproject.model.Rent;
import com.leftproject.model.User;

public interface RentService {

	void saveRent(Rent rent);
	
	//void updateReservation(Reservation employee);
	
//	void deleteRentByCode(String rentCode);

//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	Rent getRentByCode(String rentCode);
	
	List<Rent> getProposedRent();
	
	void updateRent(Rent rent);
	
	void cancelRent(Rent rent);
	
	List<Rent> getAllRent(User user);
	
//	void sendMemorandum (String memorandum);
	
	
}
