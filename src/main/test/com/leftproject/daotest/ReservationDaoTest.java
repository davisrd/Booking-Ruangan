package com.leftproject.daotest;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.websystique.springmvc.dao.*;
import com.leftproject.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class ReservationDaoTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Test
	public void testSaveReservation()
	{
		User user = userDao.getUser("UMRG00001");
		Room room = roomDao.getRoom("RG003");
		Reservation reservation = new Reservation();
		reservation.setUser(user);
		reservation.setRoom(room);
		Date date = new Date();
		reservation.setCreatedDate(date);
		reservation.setBorrower("Bambang");
		reservationDao.saveReservation(reservation);
		Reservation found = reservationDao.getReservation("RS1605002");
		assertEquals("Bambang", found.getBorrower());
	}
	
	
	
}
