package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.*;
import com.leftproject.model.*;

@Service("ReservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	
	public void saveReservation(Reservation reservation){
		reservationDao.saveReservation(reservation);
		Notification notif = new Notification();
		notif.setNotificationMessage("Pemesanan berhasil");	
	}
		
		
	public void updateReservation(Reservation reservation){
		Reservation entity = reservationDao.getReservationByCode(reservation.getReservationCode());
		if(entity!=null){
			entity.setReservationCode(reservation.getReservationCode());
	        entity.setReservationDateStart(reservation.getReservationDateStart());
	        entity.setReservationDateEnd(reservation.getReservationDateEnd());
			entity.setCreatedDate(reservation.getCreatedDate());
			entity.setReservationStatus(reservation.getReservationStatus());
			entity.setReservationPhase(reservation.getReservationPhase());
			entity.setReservationFilePath(reservation.getReservationFilePath());
			entity.setReservationOperationalPrice(reservation.getReservationOperationalPrice());
			entity.setReservationRejectReason(reservation.getReservationRejectReason());
			entity.setReservationCancelReason(reservation.getReservationCancelReason());
			entity.setEventType(reservation.getEventType());
			entity.setEventName(reservation.getEventName());
			entity.setEventScale(reservation.getEventScale());
			entity.setEventTotalParticipant(reservation.getEventTotalParticipant());
			entity.setUser(reservation.getUser());
			entity.setRoom(reservation.getRoom());
			entity.setUpdatedBy(reservation.getUpdatedBy());
		    entity.setUpdatedDate(reservation.getUpdatedDate());	       
		}
	}
	
	public Reservation getReservationByCode(String reservationCode ){
//		return reservationDao.getProposedReservation(reservationCode);
		return null;
	}
	
	public List<Reservation> getProposedReservation(){
		return reservationDao.getProposedReservation();
	}

		
	
}
