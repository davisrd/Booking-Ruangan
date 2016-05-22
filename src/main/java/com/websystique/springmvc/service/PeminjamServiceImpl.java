package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.PeminjamDao;
import com.websystique.springmvc.model.Peminjam;

@Service("peminjamService")
@Transactional
public class PeminjamServiceImpl implements PeminjamService {

	@Autowired
	private PeminjamDao dao;
	
	public Peminjam findById(int nip) {
		return dao.findById(nip);
	}

	public void savePeminjam(Peminjam employee) {
		dao.savePeminjam(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updatePeminjam(Peminjam employee) {
		Peminjam entity = dao.findById(employee.getId());
		if(entity!=null){
			entity.setNama(employee.getNama());
					
		}
	}

	public void deletePeminjamById(int ssn) {
		dao.deletePeminjamById(ssn);
	}
	
	public List<Peminjam> findAllPeminjams() {
		return dao.findAllPeminjams();
	}

	public Peminjam findPeminjamById(int ssn) {
		return dao.findPeminjamById(ssn);
	}

	/*public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}*/
	
}
