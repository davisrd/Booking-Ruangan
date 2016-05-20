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
	
	public String cancelRent(Rent rent){
		Query query = getSession().createSQLQuery("delete from RENT where rent_id = " + rent.getRentId());
		return "Pembatalan penyewaan ruangan berhasil";
	}
		
	public List<Rent> getNotYetApproveMovementRentByDirectur(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("rent_status", "M"));
		return (List<Rent>) criteria.list();
	}
	
	public List<Rent> getAllRentsByUser(User user){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("user_id", user.getuserId()));
		return (List<Rent>) criteria.list();
	}
	
	public void setRentPhase(Rent rent, char phase){
		rent.setRentPhase(phase);
		persist(rent);
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
	
	
	
	
}
