package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Reservation;
import com.websystique.springmvc.model.*;

public interface ReservationService {

	void saveReservation(Reservation employee);
	
	//void updateReservation(Reservation employee);
	
	void deleteReservationById(int ssn);

//	List<Reservation> findAllReservations(); 

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	Reservation getReservation(String reservationId);
	List<Reservation> getProposedReservation();
	
//	void sendMemorandum (String memorandum);
	
	
}
