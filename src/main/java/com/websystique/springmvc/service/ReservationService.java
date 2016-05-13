package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Reservation;

public interface ReservationService {

	void saveReservation(Reservation employee);
	
	//void updateReservation(Reservation employee);
	
	void deleteReservationById(int ssn);

//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	Reservation getReservation(String reservationId);
	List<Reservation> getProposedReservation();
}
