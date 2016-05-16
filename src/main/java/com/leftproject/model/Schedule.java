package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="SCHEDULE")
public class Schedule {
	
	@Id
    @Column(name="ID_SCHEDULE")
	@Size(max = 10)
    private String idSchedule;
	
	@Column(name="ID_ROOM_USAGE")
	@Size(max=10)
	private String idRoomUsage;
	
	@Column(name="ID_ROOM")
	@Size(max=7)
	private String idRoom;
	
	@Column(name="ID_USER")
	@Size(max=8)
	private String idUser;
	
	@Column(name="EVENT_USER_NAME")
	@Size(max=25)
	private String eventUserName;
	
	@Column(name="DATE_START")
	private Date dateStart;
	
	@Column(name="DATE_END")
	private Date dateEnd;
	
	@Column(name="EVENT_NAME")
	@Size(max=25)
	private String eventName;

	public Schedule(String idSchedule, String idRoomUsage, String idRoom, String idUser, String eventUserName,
			Date dateStart, Date dateEnd, String eventName) {
		super();
		this.idSchedule = idSchedule;
		this.idRoomUsage = idRoomUsage;
		this.idRoom = idRoom;
		this.idUser = idUser;
		this.eventUserName = eventUserName;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.eventName = eventName;
	}

	public String getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(String idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getIdRoomUsage() {
		return idRoomUsage;
	}

	public void setIdRoomUsage(String idRoomUsage) {
		this.idRoomUsage = idRoomUsage;
	}

	public String getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getEventUserName() {
		return eventUserName;
	}

	public void setEventUserName(String eventUserName) {
		this.eventUserName = eventUserName;
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

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
	
}
