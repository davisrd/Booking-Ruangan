package com.leftproject.dao;

import org.springframework.stereotype.Repository;

import com.leftproject.model.Notification;

@Repository("NotificationDao")
public class NotificationDaoImpl extends AbstractDao<Integer, Notification> implements NotificationDao{
	public void sendNotification(Notification notif){
		persist(notif);
		
	}
}
