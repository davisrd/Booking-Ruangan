package com.websystique.springmvc.dao;

import java.util.List;
import com.websystique.springmvc.model.*;
import com.leftproject.model.Reservation;
import com.leftproject.model.User;

public interface ReservationDao {
//	Reservation findById(int nip);
	
	boolean deleteReservationById(int id);
	List<Reservation> getProposedReservation();
	
	//yg dari sequence appl
	List<Reservation> getAllReservations(User user);
	
	boolean cancelReservation(Reservation reservation);
	
	/*Reservation getReservationByRoomId(String roomId);*/
	Reservation getReservation(String reservationId);
	
	boolean saveReservation(Reservation reservation);
	
	List<Reservation> getProposedMovementReservation();
	
	boolean approveReservationByRoomManager(Reservation reservation);
	
	boolean approveReservationByKaSubbagTU(Reservation reservation);
	
	boolean denyReservationByRoomManager(Reservation reservation);
	
	boolean denyReservationByKasubbagTU(Reservation reservation);
	
//	List<Reservation> findAllReservations();
}

