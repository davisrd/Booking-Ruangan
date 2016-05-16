package com.websystique.springmvc.dao;

import com.leftproject.model.Notification;


public class NotificationDaoImpl extends AbstractDao<Integer, Notification> implements NotificationDao{
	public void sendNotification(Notification notif){
		persist(notif);
		
	}
}
