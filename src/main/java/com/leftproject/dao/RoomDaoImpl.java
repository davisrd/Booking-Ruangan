package com.leftproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.Rent;
import com.leftproject.model.Room;

@Repository("RoomDao")
public class RoomDaoImpl extends AbstractDao<Integer, Room> implements RoomDao{

	private String getCurrentLastId(String roomType)
	{
		String roomCode="";
		Query query = getSession().createQuery("from Room order by reservation_code DESC");
		query.setMaxResults(1);
		List<Room> rooms = query.list();
		Room room = new Room();
		if(!rooms.isEmpty())
		{
			 room = rooms.get(0);
			 roomCode = room.getRoomCode().substring(0, 2);
			 int id = Integer.parseInt(room.getRoomCode().substring(2, 5));
			 id++;
			 roomCode = roomCode + String.format("%03d", id);
		}
		else
		{
			roomCode = roomCode+"001";
		}
		return roomCode;
	}
	
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
	
	
	public Room getRoom(String room_code)
	{
		return getByKey(room_code);
	}
}
