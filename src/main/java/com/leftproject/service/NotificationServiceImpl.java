package com.leftproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leftproject.dao.NotificationDao;
import com.leftproject.model.Notification;

@Service("NotificationService")
@Transactional
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	private NotificationDao dao;
	
	public void sendNotification(Notification notif) {
		dao.sendNotification(notif);
	}

}

