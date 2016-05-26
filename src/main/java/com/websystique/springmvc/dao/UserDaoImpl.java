package com.websystique.springmvc.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.leftproject.model.*;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<Integer, Rent> implements UserDao{

//public List<User> getUserKasubagTU(char userType) {
//	Criteria criteria = createEntityCriteria()
//			.add(Restrictions.eq("userType", "UMRG00001"));
//	return (List<User>) criteria.list();
//}
//
//public List<User> getUserPengelolaKhusus(char userType) {
//	Criteria criteria = createEntityCriteria()
//			.add(Restrictions.eq("userType", "UMRS00001"));
//	return (List<User>) criteria.list();
//}

//public void getUserDirektur(char userType) {
//	// TODO Auto-generated method stub
//	
//}

	public User getUser(String userCode) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userCode", userCode));
		return (User) criteria.uniqueResult();
	}
	


}
