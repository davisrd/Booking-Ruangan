package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.RuanganDao;
import com.websystique.springmvc.model.Ruangan;

@Service("RuanganService")
@Transactional
public class RuanganServiceImpl implements RuanganService {

	@Autowired
	private RuanganDao dao;
	
	public Ruangan findById(int nip) {
		return dao.findById(nip);
	}

	public void saveRuangan(Ruangan employee) {
		dao.saveRuangan(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateRuangan(Ruangan employee) {
		Ruangan entity = dao.findById(employee.getId());
		if(entity!=null){
			entity.setNamaRuangan(employee.getNamaRuangan());
			entity.setJenisRuangan(employee.getJenisRuangan());
		}
	}

	public void deleteRuanganById(int ssn) {
		dao.deleteRuanganById(ssn);
	}
	
	public List<Ruangan> findAllRuangans() {
		return dao.findAllRuangans();
	}

	public Ruangan findRuanganById(int ssn) {
		return dao.findRuanganById(ssn);
	}

	/*public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}*/
	
}
