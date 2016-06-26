package com.leftproject.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.*;

@Repository("ScheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer, Schedule> implements ScheduleDao{
	ReservationDao dao;

	@SuppressWarnings("unchecked")
	public List<Schedule> getListSchedule(String roomCode, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		criteria.createCriteria("room")
			.add(Restrictions.eq("roomCode", roomCode));
		criteria.add(Restrictions.or(
					Restrictions.and
						(Restrictions.le("dateStart", startDate), Restrictions.ge("dateEnd", endDate)),
					Restrictions.and
						(Restrictions.ge("dateStart", startDate), Restrictions.le("dateEnd", endDate)),
					Restrictions.and
						(Restrictions.ge("dateEnd", startDate), Restrictions.le("dateEnd", endDate)),
					Restrictions.and
						(Restrictions.ge("dateStart", startDate), Restrictions.le("dateStart", endDate))
					));
		
		return (List<Schedule>) criteria.list();
	}
	
	public Schedule getSchedule(String roomCode, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		criteria.createCriteria("room")
		.add(Restrictions.eq("roomCode", roomCode));
		criteria.add(Restrictions.or(
					Restrictions.and
					(Restrictions.le("dateStart", startDate), Restrictions.ge("dateEnd", endDate)),
				Restrictions.and
					(Restrictions.ge("dateStart", startDate), Restrictions.le("dateEnd", endDate)),
				Restrictions.and
					(Restrictions.ge("dateEnd", startDate), Restrictions.le("dateEnd", endDate)),
				Restrictions.and
					(Restrictions.ge("dateStart", startDate), Restrictions.le("dateStart", endDate))
				));
		return (Schedule) criteria.uniqueResult();
	}

	public boolean saveSchedule(Schedule schedule) {
		try{
			persist(schedule);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Schedule getSchedule(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idSchedule", id));
		
		return (Schedule) criteria.uniqueResult();
	}
}
