package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ReservationDao;
import com.leftproject.model.Reservation;

@Service("employeeService")
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao dao;

	public void saveReservation(Reservation employee) {
		dao.saveReservation(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */

	public void deleteReservationById(int ssn) {
		dao.deleteReservationById(ssn);
	}
	
/*	public List<Reservation> findAllReservations() {
		return dao.findAllReservations();
	}*/
	
	/*public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}*/
	
}
