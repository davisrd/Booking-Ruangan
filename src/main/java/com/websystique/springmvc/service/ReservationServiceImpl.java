package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leftproject.model.Reservation;
import com.websystique.springmvc.dao.ReservationDao;
import com.websystique.springmvc.model.*;

@Service("ReservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;
//	@Autowired
//	private MemorandumDao memorandumDao;
	

	public void saveReservation(Reservation employee) {
		reservationDao.saveReservation(employee);
//		Notification notif = new Notification();
//		notif.setNotificationMessage("Pemesanan berhasil");	
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */

	public void deleteReservationById(int ssn) {
		reservationDao.deleteReservationById(ssn);
	}
	
/*	public List<Reservation> findAllReservations() {
		return dao.findAllReservations();
	}*/
	
	/*public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}*/
	
	public List<Reservation> getProposedReservation(){
		return reservationDao.getProposedReservation();
	}
	public Reservation getReservation(String reservationId){
		return reservationDao.getReservation(reservationId);
	}
//	public Reservation getsendMemorandum(String memorandum){
//		return memorandumDao.getsendMemorandum(memorandum);
//		
//	}

//	public void sendMemorandum(String memorandum) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
}
