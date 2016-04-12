package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Ruangan;

@Repository("RuanganDao")
public class RuanganDaoImpl extends AbstractDao<Integer, Ruangan> implements RuanganDao {

	public Ruangan findById(int id) {
		return getByKey(id);
	}

	public void saveRuangan(Ruangan employee) {
		persist(employee);
	}

	public void deleteRuanganById(int nip) {
		Query query = getSession().createSQLQuery("delete from Ruangan where IDRUANGAN = " + nip);
//		query.setString("nip", nip);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Ruangan> findAllRuangans() {
		Criteria criteria = createEntityCriteria();
		return (List<Ruangan>) criteria.list();
	}

	public Ruangan findRuanganById(int ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", ssn));
		return (Ruangan) criteria.uniqueResult();
	}
}
