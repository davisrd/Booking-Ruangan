package com.leftproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="ROOM")
public class Room {
 
    @Id
    @GeneratedValue
    @Column(name="room_id")
    private int roomId;
     
    @Id
    @Column(name="room_code")
    @Size (max = 5)
    private char roomCode;
    
    @Column(name="room_name")
    private String roomName;
     
    @Column(name="room_status")
    private char roomStatus;
     
    @Column(name="room_price")
    private long roomPrice;
    
   @Column(name="room_category")
   private char roomCategory;
    
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private RoomManager roomManager;
     
    public Room() {
         
    }

	public Room(int roomId, char roomCode, String roomName, char roomStatus, long roomPrice, char roomCategory,
			RoomManager roomManager) {
		super();
		this.roomId = roomId;
		this.roomCode = roomCode;
		this.roomName = roomName;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
		this.roomCategory = roomCategory;
		this.roomManager = roomManager;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public char getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(char roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public char getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(char roomStatus) {
		this.roomStatus = roomStatus;
	}

	public long getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(long roomPrice) {
		this.roomPrice = roomPrice;
	}

	public char getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(char roomCategory) {
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
