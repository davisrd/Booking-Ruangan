package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.*;
import com.websystique.springmvc.model.*;
import com.leftproject.model.*;

@Service("ReservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	
	public void saveReservation(Reservation reservation){
		
	}
	
	public void deleteReservationByCode(int reservationCode){
		
	}
	
	public void updateReservation(Reservation reservation){
		
	}
	
	public Reservation getReservation(int reservationCode ){
		return reservationDao.getProposedReservation(reservationId);
	}
	
	public List<Reservation> getProposedReservation(){
		
	}

		
	
}
