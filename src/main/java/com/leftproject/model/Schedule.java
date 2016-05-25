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
	@GeneratedValue
    @Column(name="SCHEDULE_ID")
    private int idSchedule;
	
	@Column(name="USAGE_CODE")
	@Size( min = 9 ,max=9)
	private String  usageCode;

	@Column(name="DATE_START")
	@Size( min = 10 ,max=10)
	private Date  dateStart;

	@Column(name="DATE_END")
	@Size( min = 10 ,max=10)
	private Date  dateEnd;
	
	public Schedule(int idSchedule, String usageCode) {
		super();
		this.idSchedule = idSchedule;
		this.usageCode = usageCode;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getUsageCode() {
		return usageCode;
	}

	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}

	
	
	
	
}
