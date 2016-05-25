package com.leftproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.google.gson.Gson;

@Entity
@Table(name="ROOM")
public class Room {
 
    @Id
    @Column(name="ROOM_CODE")
    @Size (max = 5)
    private String roomCode;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USER_CODE")
   	@Size (min = 9 , max = 9)
    private RoomManager roomManager;
    
    @Column(name="ROOM_NAME")
    private String roomName;
     
    @Column(name="ROOM_STATUS")
    private String roomStatus;
     
    @Column(name="ROOM_PRICE")
    private Long roomPrice;
    
   @Column(name="ROOM_CATEGORY")
   private String roomCategory;
    

   public Room(){}

   public Room(String roomJSON){
	   	Gson gson = new Gson();
	   	Room room = gson.fromJson(roomJSON, Room.class);
		this.roomCode = room.roomCode;
		this.roomManager = room.roomManager;
		this.roomName = room.roomName;
		this.roomStatus = room.roomStatus;
		this.roomPrice = room.roomPrice;
		this.roomCategory = room.roomCategory;
   }

	public Room(String roomCode, RoomManager roomManager, String roomName, String roomStatus, long roomPrice, String roomCategory) {
		super();
		this.roomCode = roomCode;
		this.roomManager = roomManager;
		this.roomName = roomName;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
		this.roomCategory = roomCategory;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public Long getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Long roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}


}
    // Getter and Setter methods
