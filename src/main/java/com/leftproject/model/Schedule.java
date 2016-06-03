package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="SCHEDULE")
public class Schedule {
	
	@Id
	@GeneratedValue
    @Column(name="SCHEDULE_ID")
    private int idSchedule;

	@Autowired
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ROOM_CODE")
	private Room room;
	
	@Column(name="USAGE_STATUS")
	@Size( min = 1 ,max=1)
	private String  roomStatus;

	@Column(name="DATE_START")
	private Date  dateStart;

	@Column(name="DATE_END")
	private Date  dateEnd;
	
	public Schedule()
	{
		
	}
	
	public Schedule(int idSchedule, Room room, String roomStatus, Date dateStart, Date dateEnd) {
		super();
		this.idSchedule = idSchedule;
		this.room = room;
		this.roomStatus = roomStatus;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

}
