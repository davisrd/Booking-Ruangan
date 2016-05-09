package com.websystique.springmvc.dao;

import java.util.List;

import com.leftproject.model.Reservation;

public interface ReservationDao {
//	Reservation findById(int nip);

	void saveReservation(Reservation reservation);
//	Reservation getReservation(String roomId);
	void deleteReservationById(int id);
	List<Reservation> getProposedReservation();
	
//	List<Reservation> findAllReservations();
	
}
