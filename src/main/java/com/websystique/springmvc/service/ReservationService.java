package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Reservation;

public interface ReservationService {
	
	Boolean saveReservation(Reservation reservation);
	
	void deleteReservationByCode(String reservationCode);
	
	void updateReservation(Reservation reservation);
	
	Reservation getReservation(String reservatioCode);
	
	List<Reservation> getProposedReservation();

	//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
		
	//	void sendMemorandum (String memorandum);
	
}
