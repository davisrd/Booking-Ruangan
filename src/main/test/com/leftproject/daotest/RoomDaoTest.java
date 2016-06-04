package com.leftproject.daotest;
import java.util.List;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import org.junit.Test;
import com.leftproject.model.*;
import com.websystique.springmvc.dao.*;

public abstract class RoomDaoTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private RoomDao roomDao;
	
	@Test
	public void getRoomListTest()
	{
		Room room = roomDao.getRoom("RS001");
		assertEquals("Gedung Kuliah Bersama",room.getRoomName());
		
		
		
	}
	
	@Test
	public void getReservationRoomTest()
	{
		
	}
	
	@Test
	public void getRentRoomByCategoryTest()
	{
		
	}
	
	@Test
	public void getRoomTest()
	{
		
	}
	
	
}
