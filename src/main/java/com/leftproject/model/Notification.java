package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="NOTIFICATION")
public class Notification {
	@Id
    @Column(name="NOTIFICATION_ID", nullable = false)
	private int notificationId;
    
	
    @Column(name="NOTIFICATION_RECEIVER")
    @Size(max=8)
	private String notificationReceiver;
    
    @Column(name="NOTIFICATION_SUBJECT")
    @Size(max=50)
	private String notificationSubject;
    
    @Column(name="NOTIFICATION_MESSAGE")
	private String notificationMessage;
    
    @Column(name="NOTIFICATION_STATUS")
	private Boolean notificationStatus;
    
    @Column(name="CREATED_DATE")
	private Date createdDate;

	public Notification(int notificationId, String notificationReceiver, String notificationSubject,
			String notificationMessage, boolean notificationStatus, Date createdDate) {
		super();
		this.notificationId = notificationId;
		this.notificationReceiver = notificationReceiver;
		this.notificationSubject = notificationSubject;
		this.notificationMessage = notificationMessage;
		this.notificationStatus = notificationStatus;
		this.createdDate = createdDate;
	}

	public Notification() {
		
	}
	
	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationReceiver() {
		return notificationReceiver;
	}

	public void setNotificationReceiver(String notificationReceiver) {
		this.notificationReceiver = notificationReceiver;
	}

	public String getNotificationSubject() {
		return notificationSubject;
	}

	public void setNotificationSubject(String notificationSubject) {
		this.notificationSubject = notificationSubject;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public boolean getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(boolean notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    
    
    
}
