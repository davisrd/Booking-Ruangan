package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Rent;

@Repository("RentDao")
public class RentDaoImpl extends AbstractDao<Integer, Rent> implements RentDao{
	//getAllMinRent(User user)
	
	public String cancelRent(Rent rent){
		Query query = getSession().createSQLQuery("delete from RENT where rent_id = " + rent.getRentId());
		return "Pembatalan penyewaan ruangan berhasil";
	}
		
	public List<Rent> getProposedMovementRentByDirectur(){
		Query query = getSession().createSQLQuery("select from RENT where rent_status = M");
		//return list of rent
	}
	
	public void setRentPhase(Rent rent, char phase){
		rent.setRentPhase(phase);
		persist(rent);
	}
	
	public void saveRent(Rent rent){
		persist(rent);
	}
	
	public boolean updateRent(Rent rent){
		persist(rent);
		return true;
	}
	
	
	
	
}
