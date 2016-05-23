package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.*;
import com.websystique.springmvc.model.*;
import com.leftproject.model.*;

@Service("rentService")
@Transactional
public class RentServiceImpl implements RentService {

	@Autowired
	private RentDao rentDao;
//	@Autowired
//	private MemorandumDao memorandumDao;
	

	public void saveRent(Rent employee) {
		rentDao.saveRent(employee);
		Notification notif = new Notification();
		notif.setNotificationMessage("Pemesanan berhasil");	
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */

	public void deleteRentByCode(String rentCode) {
		rentDao.deleteRentByCode(rentCode);
	}
	
	public List<Rent> getProposedRent(){
		return rentDao.getProposedRent();
	}
	
	public Rent getRentByCode(String rentCode){
		return rentDao.getRentByCode(rentCode);
	}
	
	public void updateRent(Rent rent){
		Rent entity = rentDao.getRentByCode(rent.getRentCode());
		if(entity!=null){
			entity.setCreatedDate(rent.getCreatedDate());
	        entity.setEventCategory(rent.getEventCategory());
	        entity.setEventName(rent.getEventName());
	        entity.setRentCancelReason(rent.getRentCancelReason());
	        entity.setRentCode(rent.getRentCode());
	        entity.setRentDateStart(rent.getRentDateStart());
	        entity.setRentDateEnd(rent.getRentDateEnd());
	        entity.setRenter(rent.getRenter());
	        entity.setRentEvidencePath(rent.getRentEvidencePath());
	        entity.setRentLetterPath(rent.getRentLetterPath());
	        entity.setRentOperationalPrice(rent.getRentOperationalPrice());
	        entity.setRentPhase(rent.getRentPhase());
	        entity.setRentPrice(rent.getRentPrice());
	        entity.setRentRejectReason(rent.getRentRejectReason());
	        entity.setRentStatus(rent.getRentStatus());
	        entity.setRoom(rent.getRoom());
	        entity.setUpdatedBy(rent.getUpdatedBy());
	        entity.setUpdatedDate(rent.getUpdatedDate());
	        entity.setUserId(rent.getUserId());
		}
	}
//	public Rent getsendMemorandum(String memorandum){
//		return memorandumDao.getsendMemorandum(memorandum);
//		
//	}

	public void sendMemorandum(String memorandum) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
