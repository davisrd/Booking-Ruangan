package com.leftproject.daotest;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import org.junit.Test;
import com.leftproject.model.Room;
import com.leftproject.model.Schedule;
import com.websystique.springmvc.dao.*;

public abstract class ScheduleDaoTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	ScheduleDao scheduleDao;
	
	@Test
	public void getRoomStatusTest()
	{
		boolean status;
	}
	
	public void getListScheduleTest()
	{
		
	}
	
	@Test
	public void getScheduleTest()
	{
		
	}

}
