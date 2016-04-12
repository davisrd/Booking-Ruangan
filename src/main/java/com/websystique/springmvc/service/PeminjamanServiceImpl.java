package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.PeminjamanDao;
import com.websystique.springmvc.model.Peminjaman;

@Service("employeeService")
@Transactional
public class PeminjamanServiceImpl implements PeminjamanService {

	@Autowired
	private PeminjamanDao dao;
	
	public Peminjaman findById(int nip) {
		return dao.findById(nip);
	}

	public void savePeminjaman(Peminjaman employee) {
		dao.savePeminjaman(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updatePeminjaman(Peminjaman employee) {
		Peminjaman entity = dao.findById(employee.getId());
		if(entity!=null){
			entity.setPeminjam(employee.getPeminjam());
			entity.setTgl_pinjam(employee.getTgl_pinjam());
			entity.setJurusan(employee.getJurusan());
			entity.setKegiatan(employee.getKegiatan());
			entity.setRuangan(employee.getRuangan());
					
		}
	}

	public void deletePeminjamanById(int ssn) {
		dao.deletePeminjamanById(ssn);
	}
	
	public List<Peminjaman> findAllPeminjamans() {
		return dao.findAllPeminjamans();
	}

	public Peminjaman findPeminjamanById(int ssn) {
		return dao.findPeminjamanById(ssn);
	}

	/*public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}*/
	
}
