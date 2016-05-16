package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.NotificationDao;
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

