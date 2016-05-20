package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.*;

public interface RoomService {
	
	List<Room> getRoomList();
	
	List<Room> getRentRoomByCategory(char roomStatus, char roomCategory);
	
	Room getRoom(int room_id);
}
