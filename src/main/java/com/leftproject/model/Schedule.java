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

    private int idSchedule;
	
	@Column(name="USAGE_ID")
	@Size( min = 10 ,max=10)
	private String  usageId;

	public Schedule(int idSchedule, String usageId) {
		super();
		this.idSchedule = idSchedule;
		this.usageId = usageId;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getUsageId() {
		return usageId;
	}

	public void setUsageId(String usageId) {
		this.usageId = usageId;
	}

	
	
	
	
}
