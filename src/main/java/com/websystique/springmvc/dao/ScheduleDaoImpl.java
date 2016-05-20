package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Reservation;
import com.leftproject.model.Schedule;;

@Repository("ScheduleDao")
public class ScheduleDaoImpl extends AbstractDao<Integer, Schedule> implements ScheduleDao{
	ReservationDao dao;
	public boolean getRoomStatus(String roomId, Date startDate, Date endDate){
			
			List<Schedule> listSchedule = getListSchedule(roomId, startDate, endDate);
			if(listSchedule.isEmpty()){
				return true;
			}
			else if(listSchedule.get(0).getIdRoomUsage().substring(0, 1)=="RS"){
				Schedule schedule = listSchedule.get(0);
				Reservation reservation = dao.getReservation(schedule.getIdRoomUsage());
				if(reservation.getEventType().toUpperCase()=="AKADEMIK") return false;
			}
			else if(listSchedule.get(0).getIdRoomUsage().substring(0, 1)=="RE") return false;
			
			
		return false;
	}
	
	public List<Schedule> getListSchedule(String roomId, Date startDate, Date endDate){
		Criteria criteria = createEntityCriteria();
		Restrictions res = null;
		criteria.add(res.eq("ID_ROOM", roomId));
		criteria.add(res.between("DATE_START", startDate, endDate));
		criteria.add(res.between("DATE_END", startDate, endDate));
		return (List<Schedule>) criteria.list();
	}
	
	public Schedule getSchedule(String roomId, Date date){
		Criteria criteria = createEntityCriteria();
		Restrictions res = null;
		criteria.add(res.eq("ID_ROOM", roomId));
		criteria.add(res.like("DATE_START", new Date(date.getYear(),date.getMonth(),date.getDate()) ));
		return (Schedule) criteria.list();
	}
}
