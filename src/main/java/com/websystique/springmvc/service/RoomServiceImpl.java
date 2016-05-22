package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.*;
import com.websystique.springmvc.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("RoomService")
@Transactional
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomDao roomDao;
	
	public List<Room> getRoomList()
	{
		return roomDao.getRoomList();
	}

	public List<Room> getReservationRoom()
	{
		return roomDao.getReservationRoom();
	}

	public List<Room> getRentRoomByCategory(char roomCategory)
	{
		return roomDao.getRentRoomByCategory(roomCategory);
	}
	
	public Room getRoom(int room_id)
	{
		return roomDao.getRoom(room_id);
	}
}
