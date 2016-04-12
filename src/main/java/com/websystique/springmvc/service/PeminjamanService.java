package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Peminjaman;

public interface PeminjamanService {

	Peminjaman findById(int id);
	
	void savePeminjaman(Peminjaman employee);
	
	void updatePeminjaman(Peminjaman employee);
	
	void deletePeminjamanById(int ssn);

	List<Peminjaman> findAllPeminjamans(); 
	
	Peminjaman findPeminjamanById(int ssn);

	//boolean isEmployeeSsnUnique(Integer id, String ssn);
	
}
