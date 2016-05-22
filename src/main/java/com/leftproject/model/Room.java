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
     
    @Column(name="room_code")
    @Size (max = 7)
    private String roomCode;
    
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
   
    public Room(int roomId, String roomCode, String roomName, char roomStatus, long roomPrice, char roomCategory,
			RoomManager roomManager) {
		super();
		this.roomId = roomId;
		this.roomCode = roomCode;
		this.roomName = roomName;
		this.roomCategory = roomCategory;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
		this.roomManager = roomManager;
	}

	public int getroomId() {
		return roomId;
	}
	

	public String getRoomCode() {
		return roomCode;
	}


	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}


	public void setroomId(int roomId) {
		this.roomId = roomId;
	}

	public String getroomName() {
		return roomName;
	}

	public void setroomName(String roomName ) {
		this.roomName = roomName;
	}

	public char getroomStatus() {
		return roomStatus;
	}

	public void setroomStatus(char roomStatus) {
		this.roomStatus = roomStatus;
	}

	public long  getroomPrice() {
		return roomPrice;
	}

	public void setroomPrice(Long roomPrice) {
		this.roomPrice = roomPrice;
	}
	public RoomManager getroomManager() {
        return roomManager;
    }

    public void setRoomManager(RoomManager roomManager) {
        this.roomManager = roomManager;
    }
}
    // Getter and Setter methods
