package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Peminjaman;

public interface PeminjamanDao {
	/*this is test comment*/

	Peminjaman findById(int nip);

	void savePeminjaman(Peminjaman peminjaman);
	
	void deletePeminjamanById(int id);
	
	List<Peminjaman> findAllPeminjamans();

	Peminjaman findPeminjamanById(int id);

}
