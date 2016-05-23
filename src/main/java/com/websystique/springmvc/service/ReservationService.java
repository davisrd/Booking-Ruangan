package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Reservation;

public interface ReservationService {
	
	void saveReservation(Reservation reservation);
	
	void deleteReservationByCode(int reservationCode);
	
	void updateReservation(Reservation reservation);
	
	Reservation getReservation(int reservatioCode);
	
	List<Reservation> getProposedReservation();

	//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
		
	//	void sendMemorandum (String memorandum);
	
}
