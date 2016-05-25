package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Room;

@Repository("RoomDao")
public class RoomDaoImpl extends AbstractDao<Integer, Room> implements RoomDao{

	@SuppressWarnings("unchecked")
	public List<Room> getRoomList()
	{
		Criteria criteria = createEntityCriteria();
		return (List<Room>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Room> getReservationRoom()
	{
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.or(Restrictions.eq("roomStatus", "P"),Restrictions.eq("roomStatus", "S")));
		return (List<Room>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Room> getRentRoomByCategory(String category)
	{
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("roomCategory", category))
				.add(Restrictions.or(Restrictions.eq("roomStatus", "E"),Restrictions.eq("roomStatus", "S")));
		return (List<Room>) criteria.list();
	}
	
	
	public Room getRoom(int facility_id)
	{
		return getByKey(facility_id);
	}
}
