package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.Rent;
import com.websystique.springmvc.model.Peminjaman;

public interface PeminjamanService {

	void saveRent(Rent rent);
	
	//void updateReservation(Reservation employee);
	
	void deleteRentById(int rentId);

//	List<Reservation> findAllReservations(); 

	Rent getRent(int rentId);
	
	List<Rent> getProposedRent();
	
	void updateRent(Rent rent);
	
//	void sendMemorandum (String memorandum);
	
}
