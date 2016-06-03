package com.leftproject.daotest;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

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
		User user = userDao.getUser("UEX000001");
		assertEquals("Davis", user.getUserName());
		Room room = roomDao.getRoom("RG003");
		assertEquals("Student Center", room.getRoomName());
		Reservation reservation = new Reservation();
		reservation.setUser(user);
		reservation.setRoom(room);
		Date date = new Date();
		reservation.setCreatedDate(date);
		reservation.setBorrower("Bambang");
		int count = reservationDao.getAllReservation(user).size();
		reservationDao.saveReservation(reservation);
		reservationDao.sessionFlush();
		List<Reservation> hasil = reservationDao.getAllReservation(user);
		assertEquals(count+1, hasil.size());
	}
	
	
	
}
