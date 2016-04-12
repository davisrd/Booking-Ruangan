package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Peminjam;

public interface PeminjamService {

	Peminjam findById(int id);
	
	void savePeminjam(Peminjam employee);
	
	void updatePeminjam(Peminjam employee);
	
	void deletePeminjamById(int ssn);

	List<Peminjam> findAllPeminjams(); 
	
	Peminjam findPeminjamById(int ssn);

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	
}
