package com.leftproject.dao;

import java.util.List;
import com.leftproject.model.Reservation;
import com.leftproject.model.User;

public interface ReservationDao {
//	Reservation findById(int nip);
	
	boolean deleteReservationById(String reservationCode);
	List<Reservation> getProposedReservation();
	
	//yg dari sequence appl
	List<Reservation> getAllReservation(User user);
	
	boolean cancelReservation(Reservation reservation);
	
	/*Reservation getReservationByRoomId(String roomId);*/
	Reservation getReservation(String reservationCode);
	
	Reservation getReservationByCode(String reservationCode);
	
	boolean saveReservation(Reservation reservation);
	
	List<Reservation> getProposedMovementReservation();
	
	boolean approveReservationByRoomManager(Reservation reservation);
	
	boolean approveReservationByKaSubbagTU(Reservation reservation);
	
	boolean denyReservationByRoomManager(Reservation reservation);
	
	boolean denyReservationByKasubbagTU(Reservation reservation);
	
	void sessionFlush();
//	List<Reservation> findAllReservations();
	List<Reservation> getReservationSpecialRoom();
	
	List<Reservation> getReservationGeneralRoom();
}

