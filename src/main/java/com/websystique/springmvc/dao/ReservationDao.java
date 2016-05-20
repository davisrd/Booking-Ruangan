package com.websystique.springmvc.dao;

import java.util.List;
import com.leftproject.model.Reservation;
import com.leftproject.model.User;

public interface ReservationDao {
//	Reservation findById(int nip);
	
	void deleteReservationById(int id);
	List<Reservation> getProposedReservation();
	
	//yg dari sequence appl
	List<Reservation> getAllReservations(User user);
	
	String cancelReservation(Reservation reservation);
	
	/*Reservation getReservationByRoomId(String roomId);*/
	Reservation getReservation(String reservationId);
	
	void saveReservation(Reservation reservation);
	
	List<Reservation> getProposedMovementReservation();
	
	String approveReservationByRoomManager(Reservation reservation);
	
	String approveReservationByKaSubbagTU(Reservation reservation);
	
	String denyReservationByRoomManager(Reservation reservation);
	
	String denyReservationByKasubbagTU(Reservation reservation);
	
//	List<Reservation> findAllReservations();
}
