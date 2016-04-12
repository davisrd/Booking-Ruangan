package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Ruangan;

public interface RuanganDao {

	Ruangan findById(int nip);

	void saveRuangan(Ruangan Ruanganan);
	
	void deleteRuanganById(int id);
	
	List<Ruangan> findAllRuangans();

	Ruangan findRuanganById(int id);
}
