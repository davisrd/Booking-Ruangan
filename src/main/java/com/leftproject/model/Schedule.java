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
    @Column(name="SCHEDULE_ID")
	@Size(max = 10)
    private int idSchedule;
	
	@Column(name="USAGE_ID")
	@Size(max=10)
	private char[] idRoomUsage;

	public Schedule(int idSchedule, char[] idRoomUsage) {
		super();
		this.idSchedule = idSchedule;
		this.idRoomUsage = idRoomUsage;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public char[] getIdRoomUsage() {
		return idRoomUsage;
	}

	public void setIdRoomUsage(char[] idRoomUsage) {
		this.idRoomUsage = idRoomUsage;
	}
	
	
	
	
	
	
}
