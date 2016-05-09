package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATION")
public class Notification {
    
    @Column(name="NOTIFICATION_ID")
	private String notificationId;
    
    @Column(name="NOTIFICATION_RECEIVER")
	private String notificationReceiver;
    
    @Column(name="NOTIFICATION_SUBJECT")
	private String notificationSubject;
    
    @Column(name="NOTIFICATION_MESSAGE")
	private String notificationMessage;
    
    @Column(name="NOTIFICATION_STATUS")
	private String notificationStatus;
    
    @Column(name="CREATED_DATE")
	private Date createdDate;

	public Notification(String notificationId, String notificationReceiver, String notificationSubject,
			String notificationMessage, String notificationStatus, Date createdDate) {
		super();
		this.notificationId = notificationId;
		this.notificationReceiver = notificationReceiver;
		this.notificationSubject = notificationSubject;
		this.notificationMessage = notificationMessage;
		this.notificationStatus = notificationStatus;
		this.createdDate = createdDate;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
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

	public String getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    
    
    
}
