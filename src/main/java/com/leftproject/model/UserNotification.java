package com.leftproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATION")
public class UserNotification {
    
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
}
