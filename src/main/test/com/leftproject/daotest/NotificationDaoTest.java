 package com.leftproject.daotest;
 import static org.junit.Assert.assertEquals;

 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 import org.springframework.test.context.support.AnnotationConfigContextLoader;
 import org.junit.Test;
 import org.junit.runner.RunWith;

 import com.leftproject.model.User;
 import com.leftproject.model.Notification;
import com.leftproject.model.Reservation;
import com.websystique.springmvc.dao.*;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class NotificationDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	NotificationDao notificationDao;
	@Autowired
	UserDao userDao;
	
	@Test
	public void sendNotification ()
	{
		User user = userDao.getUser("UEX000001");
		Notification notification = new Notification();
		notification.setNotificationSubject("cincau hijau");
		
		notificationDao.sendNotification(notification);
		
		//int count = notificationDao.getsendNotification(user).size();
		//List<Notification> hasil = notificationDao.getsendNotification(user));
		//assertEquals(count+1, hasil.size());
		
		
	}
	
		
}
