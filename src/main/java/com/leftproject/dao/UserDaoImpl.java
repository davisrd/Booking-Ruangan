package com.leftproject.dao;

import org.springframework.stereotype.Repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.leftproject.model.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

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
	
	public User findById(String code) {
		return getByKey(code);
	}

	public User findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", name));
		return (User) crit.uniqueResult();
	}

	public User Login(String userCode, String password) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eqOrIsNull("userCode", userCode));
		crit.add(Restrictions.eqOrIsNull("userPassword", password));
		return (User) crit.uniqueResult();
	}

}
