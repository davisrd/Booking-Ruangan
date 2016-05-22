package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.*;
import com.leftproject.model.Rent;
import com.leftproject.model.Room;

@Repository("RentDao")
public class RentDaoImpl extends AbstractDao<Integer, Rent> implements RentDao{
	//getAllMinRent(User user)
	
	public Rent getRent(int rentId)
	{
		return getByKey(rentId);
	}
	
	public List<Rent> getProposedRent(){
		Criteria criteria = createEntityCriteria();
		return (List<Rent>) criteria.list();
	}
	
	public String cancelRent(Rent rent){
		Query query = getSession().createSQLQuery("delete from RENT where rent_id = " + rent.getRentId());
		return "Pembatalan penyewaan ruangan berhasil";
	}
		
	public void deleteRentById(int id) {
		Query query = getSession().createSQLQuery("delete from RENT where rent_ID = " + id);
//		query.setString("nip", nip);
		query.executeUpdate();
	}
	
	public List<Rent> getProposedMovementRentByDirectur(){
		Query query = getSession().createSQLQuery("select from RENT where rent_status = M");
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("rentStatus", 'M'));
		return (List<Rent>) criteria.list();
		//return list of rent
	}
	
	public void setRentPhase(Rent rent){
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
