package com.websystique.springmvc.dao;

import com.leftproject.model.Notification;

public interface NotificationDao {
	
	void sendNotification(Notification notif);
	
	
}
