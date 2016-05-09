package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Notification;

public interface NotificationDao {
	
	void sendNotification(Notification notif);
	
	
}
