package com.leftproject.service;

import java.util.List;

import com.leftproject.model.Reservation;

import com.leftproject.model.*;

public interface ReservationService {
	
	void saveReservation(Reservation reservation);
	
	void updateReservation(Reservation reservation);
	
	Reservation getReservationByCode(String reservationCode);

	List<Reservation> getProposedReservation();
	
	List<Reservation> getAllReservation(User user);
	
	void cancelReservation(Reservation reservation);

	//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
		
	//	void sendMemorandum (String memorandum);
	
}
