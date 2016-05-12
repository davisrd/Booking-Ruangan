package com.websystique.springmvc.service;

import java.util.List;

import com.leftproject.model.*;

public interface RoomService {
	
	List<Room> getRoomList();
	
	Room getRoom(int room_id);
}
