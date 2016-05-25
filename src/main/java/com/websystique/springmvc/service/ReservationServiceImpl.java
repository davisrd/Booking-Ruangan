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
		
	}
	
	public void deleteReservationByCode(String reservationCode){
		
	}
	
	public void updateReservation(Reservation reservation){
		
	}
	
	public Reservation getReservation(String reservationCode ){
//		return reservationDao.getProposedReservation(reservationCode);
		return null;
	}
	
	public List<Reservation> getProposedReservation(){
		return null;
	}

		
	
}
