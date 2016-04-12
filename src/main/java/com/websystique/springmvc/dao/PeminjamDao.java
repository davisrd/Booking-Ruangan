package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Peminjam;

public interface PeminjamDao {

	Peminjam findById(int nip);

	void savePeminjam(Peminjam peminjaman);
	
	void deletePeminjamById(int id);
	
	List<Peminjam> findAllPeminjams();

	Peminjam findPeminjamById(int id);

}
