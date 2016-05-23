package com.leftproject.dao;

import java.util.List;

import com.leftproject.model.Room;

public interface RoomDao {

	List<Room> getRoomList();
	
	List<Room> getReservationRoom();

	List<Room> getRentRoomByCategory(char category);
	
	Room getRoom(int room_id);
}
