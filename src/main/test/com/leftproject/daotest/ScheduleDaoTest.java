package com.leftproject.daotest;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.leftproject.model.Room;
import com.leftproject.model.Schedule;
import com.websystique.springmvc.dao.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class ScheduleDaoTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	ScheduleDao scheduleDao;
	
	@Autowired
	RoomDao roomDao;
	
	@Test
	public void getRoomEmptyStatusTest()
	{
		Room room = roomDao.getRoom("RG003");
		assertEquals("Student Center", room.getRoomName());
		
		Date date = new Date();
		int status = scheduleDao.getListSchedule(room.getRoomCode(), date, date).size();
		assertEquals(status, 0);
	}

	@Test
	public void getRoomUsedStatusTest()
	{
		Room room = roomDao.getRoom("RG002");
//		assertEquals("Student Center", room.getRoomName());
		
		Date date = new Date();
		int status = scheduleDao.getListSchedule(room.getRoomCode(), date, date).size();
		assertEquals(status, 1);
	}
	
	@Test
	public void getScheduleTest()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Schedule schedule = null;
		try{
			schedule = scheduleDao.getSchedule("RG002", df.parse("2016-06-03 00:00:00"), df.parse("2016-06-04 00:00:00"));
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(schedule.getRoom().getRoomCode(), "RG002");
	}

}
