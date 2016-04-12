package com.websystique.springmvc.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Peminjaman;

@Repository("PeminjamanDao")
public class PeminjamanDaoImpl extends AbstractDao<Integer, Peminjaman> implements PeminjamanDao {

	public Peminjaman findById(int id) {
		return getByKey(id);
	}

	public void savePeminjaman(Peminjaman employee) {
		persist(employee);
	}

	public void deletePeminjamanById(int nip) {
		Query query = getSession().createSQLQuery("delete from Peminjaman where idPeminjaman = " + nip);
//		query.setString("nip", nip);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Peminjaman> findAllPeminjamans() {
		Criteria criteria = createEntityCriteria();
		return (List<Peminjaman>) criteria.list();
	}

	public Peminjaman findPeminjamanById(int ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", ssn));
		return (Peminjaman) criteria.uniqueResult();
	}
}
