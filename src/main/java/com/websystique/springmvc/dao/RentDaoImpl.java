package com.websystique.springmvc.dao;

import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Rent;
import com.leftproject.model.Reservation;
import com.leftproject.model.User;

@Repository("RentDao")
public class RentDaoImpl extends AbstractDao<Integer, Rent> implements RentDao{
	//getAllMinRent(User user)
	
	public boolean cancelRent(Rent rent){
		try{
			Query query = getSession().createSQLQuery("delete from RENT where rent_id = " + rent.getRentCode());
		    query.executeUpdate();
			return true;
		}
		catch(Exception e){
			System.out.println(e.toString());
			return false;
		}				
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
	
	public boolean setRentPhase(Rent rent, String phase){
		try{
			rent.setRentCode(phase);
			persist(rent);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	public boolean saveRent(Rent rent){
		try{
			persist(rent);
			return true;
		}
		catch(Exception e){
			return false;
		}		
	}
	
	public boolean updateRent(Rent rent){
		try{
			persist(rent);
			return true;
		}
		catch(Exception e){
			return false;
		}	
	}
	
	public List<Rent> getAllMinRent(User user){
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
		
		return (List<Rent>)UserRentListToCancel;
	}
	
	public List<Rent> getProposedRent(){
		Criteria criteria = createEntityCriteria();
		return (List<Rent>) criteria.list();
	}
	
	public Rent getRentByCode(String rentCode){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("rentCode", rentCode));
		return (Rent) criteria.list();
	}
}
