package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Reservation;

public interface ReservationService {
	
	void saveReservation(Reservation reservation);
	
	void updateReservation(Reservation reservation);
	
	Reservation getReservationByCode(String reservationCode);
	
	List<Reservation> getProposedReservation();

	//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
		
	//	void sendMemorandum (String memorandum);
	
}
