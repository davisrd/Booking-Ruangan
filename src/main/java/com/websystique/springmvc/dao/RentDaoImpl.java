package com.websystique.springmvc.dao;

import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.*;
import com.leftproject.model.Rent;
import com.leftproject.model.Room;
import com.leftproject.model.Reservation;
import com.leftproject.model.User;

@Repository("RentDao")
public class RentDaoImpl extends AbstractDao<Integer, Rent> implements RentDao{
	//getAllMinRent(User user)
	
	public Rent getRentByCode(String rentCode)
	{
		return getByKey(rentCode);
	}
	
	public List<Rent> getProposedRent(){
		Criteria criteria = createEntityCriteria();
		return (List<Rent>) criteria.list();
	}
	
	public String cancelRent(Rent rent){
		Query query = getSession().createSQLQuery("delete from RENT where rent_code = " + rent.getRentCode());
		return "Pembatalan penyewaan ruangan berhasil";
	}
	
	public List<Rent> getProposedMovementRentByDirectur(){
		Query query = getSession().createSQLQuery("select from RENT where rent_status = M");
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("rentStatus", 'M'));
		return (List<Rent>) criteria.list();
		//return list of rent
	}
	
	public List<Rent> getNotYetApproveMovementRentByDirectur(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("rentStatus", "M"));
		return (List<Rent>) criteria.list();
	}
	
	public List<Rent> getAllRentsByUser(User user){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userCode", user.getUserCode()));
		return (List<Rent>) criteria.list();
	}
	
	public String setRentPhase(Rent rent, String phase){
		rent.setRentPhase(phase);
		persist(rent);
		return "Berhasil";
	}
	
	public boolean saveRent(Rent rent){
		persist(rent);
		return true;
	}
	
	public boolean updateRent(Rent rent){
		persist(rent);
		return true;
	}
	
	public void getAllMinRent(User user){
		List<Rent> UserRentList= getAllRentsByUser(user);
		List<Rent> UserRentListToCancel=null; 
		
		int minDaysCondition = 3;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -minDaysCondition);
	
		Date date = cal.getTime();

		for (Rent obj : UserRentList) {
		    if (obj.getRentDateStart().compareTo(date)<0) {
		    	//Date1 is before Date2
		    	UserRentListToCancel.add(obj);
		    }
		}

	}

	public void deleteRentByCode(String rentCode) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from RENT where rent_code = " + rentCode);
		
	}
	
}
