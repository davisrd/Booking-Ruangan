package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Ruangan;

public interface RuanganService {

	Ruangan findById(int id);
	
	void saveRuangan(Ruangan employee);
	
	void updateRuangan(Ruangan employee);
	
	void deleteRuanganById(int ssn);

	List<Ruangan> findAllRuangans(); 
	
	Ruangan findRuanganById(int ssn);

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	
}
