package com.leftproject.dao;

import java.util.*;
import java.util.Date;
import java.util.Calendar;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Rent;
import com.leftproject.model.User;

@Repository("RentDao")
public class RentDaoImpl extends AbstractDao<Integer, Rent> implements RentDao{
	//getAllMinRent(User user)
	
	private String getCurrentLastId(String mmYY)
	{
		String rentCode;
		Query query = getSession().createQuery("from Rent where substring(rent_code,3,4)='"+mmYY+"' order by rent_code DESC");
		query.setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<Rent> rents = query.list();
		Rent rent = new Rent();
		if(!rents.isEmpty())
		{
			 rent = rents.get(0);
			 rentCode = rent.getRentCode().substring(0, 6);
			 int id = Integer.parseInt(rent.getRentCode().substring(6, 9));
			 id++;
			 rentCode = rentCode + String.format("%03d", id);
		}
		else
		{
			rentCode = "RE"+mmYY+"001";
		}
		return rentCode;
	}
	
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

	@SuppressWarnings("unchecked")
	public List<Rent> getNotYetApproveMovementRentByDirectur(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("rentStatus", "M"));
		return (List<Rent>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Rent> getAllRentsByUser(User user){
		Criteria criteria = createEntityCriteria();
		criteria.createCriteria("user")
			.add(Restrictions.eq("userCode", user.getUserCode()));
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
			Date currentDate = new Date();
			rent.setCreatedDate(currentDate);
			rent.setRentCode(this.getCurrentLastId(dateToYYMM(rent.getCreatedDate())));
			rent.setRentOperationalPrice(0);
			rent.setRentPrice(rent.getRoom().getRoomPrice());
			persist(rent);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean updateRent(Rent rent){
		try{
			saveOrUpdate(rent);
			return true;
		}
		catch(Exception e){
			return false;
		}	
	}
	
	public List<Rent> getAllMinRent(User user){
		List<Rent> UserRentList= getAllRentsByUser(user);
		List<Rent> UserRentListToCancel = new ArrayList<Rent>();
		
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

	@SuppressWarnings("unchecked")
	public List<Rent> getProposedRent(){
		Criteria criteria = createEntityCriteria();
		return (List<Rent>) criteria.list();
	}
	
	public Rent getRentByCode(String rentCode){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("rentCode", rentCode));
		return (Rent) criteria.uniqueResult();
	}
}
