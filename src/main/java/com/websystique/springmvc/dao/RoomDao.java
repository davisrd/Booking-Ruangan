package com.websystique.springmvc.dao;

import java.util.List;

import com.leftproject.model.Room;
import com.websystique.springmvc.model.*;

public interface RoomDao {

	List<Room> getRoomList();
	
	List<Room> getReservationRoom();

	List<Room> getRentRoomByCategory(char category);
	
	Room getRoom(int room_id);
}
