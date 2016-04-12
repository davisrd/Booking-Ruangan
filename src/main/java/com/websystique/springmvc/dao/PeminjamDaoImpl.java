package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Peminjam;

@Repository("PeminjamDao")
public class PeminjamDaoImpl extends AbstractDao<Integer, Peminjam> implements PeminjamDao {

	public Peminjam findById(int id) {
		return getByKey(id);
	}

	public void savePeminjam(Peminjam employee) {
		persist(employee);
	}

	public void deletePeminjamById(int nip) {
		Query query = getSession().createSQLQuery("delete from Peminjam where idPeminjam = " + nip);
//		query.setString("nip", nip);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Peminjam> findAllPeminjams() {
		Criteria criteria = createEntityCriteria();
		return (List<Peminjam>) criteria.list();
	}

	public Peminjam findPeminjamById(int ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", ssn));
		return (Peminjam) criteria.uniqueResult();
	}
}
