package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.*;

public interface RoomService {

	List<Room> getRoomList();

	List<Room> getReservationRoom();
	
	List<Room> getRentRoomByCategory(String roomCategory);
	
	Room getRoom(String room_id);
}
