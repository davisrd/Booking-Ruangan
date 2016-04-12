package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Peminjaman;
import com.websystique.springmvc.service.PeminjamanService;
import com.websystique.springmvc.model.Peminjam;
import com.websystique.springmvc.service.PeminjamService;
import com.websystique.springmvc.model.Ruangan;
import com.websystique.springmvc.service.RuanganService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	PeminjamanService peminjamanService;
	@Autowired
	PeminjamService peminjamService;
	@Autowired
	RuanganService ruanganService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String getIndexPage() {
		return "UserManagement";
	}
	
	@RequestMapping(value = { "/PeminjamManagement"}, method = RequestMethod.GET)
	public String getPeminjamPage() {
		return "PeminjamManagement";
	}
	
	@RequestMapping(value = { "/RuanganManagement"}, method = RequestMethod.GET)
	public String getRuanganPage() {
		return "RuanganManagement";
	}
	
	//-------------------Retrieve All peminjams--------------------------------------------------------
    
    @RequestMapping(value = "/peminjam", method = RequestMethod.GET)
    public ResponseEntity<List<Peminjam>> listAllPeminjams() {
        List<Peminjam> employees = peminjamService.findAllPeminjams();
        if(employees.isEmpty()){
            return new ResponseEntity<List<Peminjam>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Peminjam>>(employees, HttpStatus.OK);
    }
 
    //-------------------Retrieve All Peminjamans--------------------------------------------------------
    
    @RequestMapping(value = "/peminjaman", method = RequestMethod.GET)
    public ResponseEntity<List<Peminjaman>> listAllPeminjamans() {
        List<Peminjaman> employees = peminjamanService.findAllPeminjamans();
        if(employees.isEmpty()){
            return new ResponseEntity<List<Peminjaman>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Peminjaman>>(employees, HttpStatus.OK);
    }
 
    //-------------------Retrieve All Ruangans--------------------------------------------------------
    
    @RequestMapping(value = "/ruangan", method = RequestMethod.GET)
    public ResponseEntity<List<Ruangan>> listAllRuangans() {
        List<Ruangan> employees = ruanganService.findAllRuangans();
        if(employees.isEmpty()){
            return new ResponseEntity<List<Ruangan>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Ruangan>>(employees, HttpStatus.OK);
    }
 
    
    //-------------------Retrieve Single Peminjam--------------------------------------------------------
     
    @RequestMapping(value = "/peminjam/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Peminjam> getPeminjam(@PathVariable("id") int id) {
        System.out.println("Fetching Employee with id " + id);
        Peminjam employee = peminjamService.findById(id);
        if (employee == null) {
            System.out.println("User with nip " + id + " not found");
            return new ResponseEntity<Peminjam>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Peminjam>(employee, HttpStatus.OK);
    }
 
    
    //-------------------Retrieve Single Peminjaman--------------------------------------------------------
     
    @RequestMapping(value = "/peminjaman/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Peminjaman> getEmployee(@PathVariable("id") int id) {
        System.out.println("Fetching Employee with nip " + id);
        Peminjaman employee = peminjamanService.findById(id);
        if (employee == null) {
            System.out.println("User with nip " + id + " not found");
            return new ResponseEntity<Peminjaman>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Peminjaman>(employee, HttpStatus.OK);
    }
     
  //-------------------Retrieve Single Ruangan--------------------------------------------------------
    
    @RequestMapping(value = "/ruangan/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ruangan> getRuangan(@PathVariable("id") int id) {
        System.out.println("Fetching Employee with nip " + id);
        Ruangan employee = ruanganService.findById(id);
        if (employee == null) {
            System.out.println("User with nip " + id + " not found");
            return new ResponseEntity<Ruangan>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Ruangan>(employee, HttpStatus.OK);
    }
     
    //-------------------Create a Peminjam--------------------------------------------------------
     
    @RequestMapping(value = "/peminjam", method = RequestMethod.POST)
    public ResponseEntity<Void> createPeminjam(@RequestBody Peminjam employee, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating Employee " + employee.getNama());
// 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
 
        peminjamService.savePeminjam(employee);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/peminjam/{id}").buildAndExpand(employee.getNip()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
  //-------------------Create a Peminjaman--------------------------------------------------------
    @RequestMapping(value = "/peminjaman", method = RequestMethod.POST)
    public ResponseEntity<Void> createPeminjaman(@RequestBody Peminjaman employee, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating Employee " + employee.getNama());
// 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
    	System.out.println("Creating Peminjaman : " + employee.getId());
 
        peminjamanService.savePeminjaman(employee);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/peminjaman/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
  //-------------------Create a Ruangan--------------------------------------------------------
    
    @RequestMapping(value = "/ruangan", method = RequestMethod.POST)
    public ResponseEntity<Void> createRuangan(@RequestBody Ruangan employee, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating Employee " + employee.getNama());
// 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
    	System.out.println("Creating Ruangan");
 
        ruanganService.saveRuangan(employee);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ruangan/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
     
    //------------------- Update a Peminjam --------------------------------------------------------
     
    @RequestMapping(value = "/peminjam/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Peminjam> updatePeminjam(@PathVariable("id") int id, @RequestBody Peminjam employee) {
        System.out.println("Updating Employee " + id);
         
        Peminjam currentEmployee = peminjamService.findById(id);
         
        if (currentEmployee==null) {
            System.out.println("Employee with nip " + id + " not found");
            return new ResponseEntity<Peminjam>(HttpStatus.NOT_FOUND);
        }
 
        currentEmployee.setNip(employee.getNip());
        currentEmployee.setNama(employee.getNama());
         
        peminjamService.updatePeminjam(currentEmployee);
        return new ResponseEntity<Peminjam>(currentEmployee, HttpStatus.OK);
    }
 
    
  //------------------- Update a Peminjaman --------------------------------------------------------
    
    @RequestMapping(value = "/peminjaman/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Peminjaman> updatePeminjaman(@PathVariable("id") int id, @RequestBody Peminjaman employee) {
        System.out.println("Updating Employee " + id);
         
        Peminjaman currentEmployee = peminjamanService.findById(id);
         
        if (currentEmployee==null) {
            System.out.println("Employee with nip " + id + " not found");
            return new ResponseEntity<Peminjaman>(HttpStatus.NOT_FOUND);
        }
 
        currentEmployee.setPeminjam(employee.getPeminjam());
        currentEmployee.setJurusan(employee.getJurusan());
        currentEmployee.setTgl_pinjam(employee.getTgl_pinjam());
        currentEmployee.setKegiatan(employee.getKegiatan());
        currentEmployee.setRuangan(employee.getRuangan());
         
        peminjamanService.updatePeminjaman(currentEmployee);
        return new ResponseEntity<Peminjaman>(currentEmployee, HttpStatus.OK);
    }
    
    
  //------------------- Update a Ruangan --------------------------------------------------------
    
    @RequestMapping(value = "/ruangan/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Ruangan> updateEmployee(@PathVariable("id") int id, @RequestBody Ruangan employee) {
        System.out.println("Updating Employee " + id);
         
        Ruangan currentEmployee = ruanganService.findById(id);
         
        if (currentEmployee==null) {
            System.out.println("Employee with nip " + id + " not found");
            return new ResponseEntity<Ruangan>(HttpStatus.NOT_FOUND);
        }
 
        currentEmployee.setNoRuangan(employee.getNoRuangan());
        currentEmployee.setJenisRuangan(employee.getJenisRuangan());
        currentEmployee.setNamaRuangan(employee.getNamaRuangan());
         
        ruanganService.updateRuangan(currentEmployee);
        return new ResponseEntity<Ruangan>(currentEmployee, HttpStatus.OK);
    }
    
    
    //------------------- Delete a Peminjam --------------------------------------------------------
    
    @RequestMapping(value = "/peminjam/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Peminjam> deletePeminjam(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Employee with id " + id);
 
        Peminjam employee = peminjamService.findById(id);
        if (employee == null) {
            System.out.println("Unable to delete. Employee with nip " + id + " not found");
            return new ResponseEntity<Peminjam>(HttpStatus.NOT_FOUND);
        }
 
        peminjamService.deletePeminjamById(id);
        return new ResponseEntity<Peminjam>(HttpStatus.NO_CONTENT);
    }
    
    //------------------- Delete a Peminjaman --------------------------------------------------------
     
    @RequestMapping(value = "/peminjaman/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Peminjaman> deletePeminjaman(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Employee with nip " + id);
 
        Peminjaman employee = peminjamanService.findById(id);
        if (employee == null) {
            System.out.println("Unable to delete. Employee with nip " + id + " not found");
            return new ResponseEntity<Peminjaman>(HttpStatus.NOT_FOUND);
        }
 
        peminjamanService.deletePeminjamanById(id);
        return new ResponseEntity<Peminjaman>(HttpStatus.NO_CONTENT);
    }
 
 //------------------- Delete a Ruangan --------------------------------------------------------
    
    @RequestMapping(value = "/ruangan/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ruangan> deleteRuangan(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Employee with nip " + id);
 
        Ruangan employee = ruanganService.findById(id);
        if (employee == null) {
            System.out.println("Unable to delete. Employee with nip " + id + " not found");
            return new ResponseEntity<Ruangan>(HttpStatus.NOT_FOUND);
        }
 
        ruanganService.deleteRuanganById(id);
        return new ResponseEntity<Ruangan>(HttpStatus.NO_CONTENT);
    }
    
//    //------------------- Delete All Users --------------------------------------------------------
//     
//    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
//    public ResponseEntity<Employee> deleteAllEmployees() {
//        System.out.println("Deleting All Employees");
// 
//        userService.deleteAllEmployees();
//        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
//    }
}
