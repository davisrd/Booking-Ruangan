package com.leftproject.daotest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.leftproject.dao.*;

public abstract class ReservationDaoTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private ReservationDao reservationDao;
	
	
	
	
}
