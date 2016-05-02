package com.leftproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room {
 
    @Id
    @GeneratedValue
    @Column(name="room_id")
    private String roomId;
     
    @Column(name="room_name")
    private String roomName;
     
    @Column(name="room_type")
    private Boolean roomType;
     
    @Column(name="room_status")
    private Boolean roomStatus;
     
    @Column(name="room_price")
    private long roomPrice;
    
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private RoomManager roomManager;
     
    public Room() {
         
    }
   
    
    public Room(String roomId, String roomName,boolean roomType, boolean roomStatus, long roomPrice){
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.roomPrice = roomPrice;
    }

	public String getroomId() {
		return roomId;
	}

	public void setroomId(String roomId) {
		this.roomId = roomId;
	}

	public String getroomName() {
		return roomName;
	}

	public void setroomName(String roomName ) {
		this.roomName = roomName;
	}

	public boolean getroomType() {
		return roomType;
	}

	public void setroomType(boolean roomType ) {
		this.roomType = roomType;
	}


	public boolean getroomStatus() {
		return roomStatus;
	}

	public void setroomStatus(boolean roomStatus) {
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
