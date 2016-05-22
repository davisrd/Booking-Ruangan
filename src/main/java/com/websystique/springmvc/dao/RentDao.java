package com.websystique.springmvc.dao;

import java.util.List;

import com.leftproject.model.Rent;
<<<<<<< HEAD
import com.websystique.springmvc.model.*;
=======
import com.leftproject.model.User;
>>>>>>> refs/remotes/origin/master


public interface RentDao {
	String cancelRent(Rent rent);
		
<<<<<<< HEAD
//	List<Rent> getAllRentUnacceptedByDirectur();
	
	List<Rent> getProposedRent();

	Rent getRent(int rentId);
	
	void deleteRentById(int id);
=======
	List<Rent> getNotYetApproveMovementRentByDirectur();
>>>>>>> refs/remotes/origin/master
	
	String setRentPhase(Rent rent, char phase);
	
	boolean saveRent(Rent rent);
	
	boolean updateRent(Rent rent);
	
	void getAllMinRent(User user);
	
	public List<Rent> getAllRentsByUser(User user);
}
