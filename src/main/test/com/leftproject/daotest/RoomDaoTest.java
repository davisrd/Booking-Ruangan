package com.leftproject.daotest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.leftproject.model.*;
import com.websystique.springmvc.dao.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class RoomDaoTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private RoomDao roomDao;
	
	@Test
	public void getRoomTest()
	{
		Room room = null;
		try{
			room = roomDao.getRoom("RS001");
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(room.getRoomCode(),"RS001");
	}
	
	@Test
	public void getReservationRoomTest()
	{
		Room room = null;
		try{
			room = roomDao.getRoom("RG003");
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(room.getRoomStatus(),"P");
	}
	
	@Test
	public void getRentRoomByCategoryTest()
	{
		Room room = null;
		try{
			room = roomDao.getRoom("RG001");
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(room.getRoomStatus(),"S");
	}
	
	
	
}
