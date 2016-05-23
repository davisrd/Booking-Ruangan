package com.websystique.springmvc.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.leftproject.model.*;
import com.websystique.springmvc.service.*;
import com.websystique.springmvc.model.*;

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
	RoomService roomService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	RentService rentService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return "redirect:/app/index.html";
	}
	
	//-------------------Retrieve All Room--------------------------------------------------------
    
    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getAllRoom() {
        List<Room> rooms = roomService.getRoomList();
        if(rooms.isEmpty()){
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }

	//-------------------Retrieve All Reservable Room--------------------------------------------------------
    
    @RequestMapping(value = "/reservationRoom", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getAllReservableRoom() {
        List<Room> rooms = roomService.getReservationRoom();
        if(rooms.isEmpty()){
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }
    
    //-------------------Use Case : Mengajukan Penyewaan--------------------------------------------------------

    @RequestMapping(value = "/rentRoom/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Room>> getAllRentableRoom(@PathVariable("category") char category) {
    	List<Room> rooms = roomService.getRentRoomByCategory(category); // With condition it should be
        if(rooms.isEmpty()){
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/roomAvailibility/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getRoomAvailibility(@PathVariable("id") String id, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
    	Boolean status = scheduleService.getRoomStatus(id, startDate, endDate); // With condition it should be
//        Boolean status = true;
    	if(status==false){
            return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/rent", method = RequestMethod.GET)
    public ResponseEntity<List<Rent>> getAllRent() {
        List<Rent> rents = rentService.getProposedRent();
        if(rents.isEmpty()){
            return new ResponseEntity<List<Rent>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Rent>>(rents, HttpStatus.OK);
    }

    @RequestMapping(value = "/rent", method = RequestMethod.POST)
    public ResponseEntity<Void> saveRent(@RequestBody Rent rent, UriComponentsBuilder ucBuilder)
    {
    	System.out.println("Create Rent with eventName : " + rent.getEventName());
    	rentService.saveRent(rent);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/rent/{id}").buildAndExpand(rent.getRentCode()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Rent> saveRent(@PathVariable("id") String id, @RequestBody Rent rent, UriComponentsBuilder ucBuilder)
    {
    	System.out.println("Updating Employee " + id);
        
        Rent currentRent = rentService.getRentByCode(id);
         
        if (currentRent==null) {
            System.out.println("Employee with nip " + id + " not found");
            return new ResponseEntity<Rent>(HttpStatus.NOT_FOUND);
        }
 
        currentRent.setCreatedDate(rent.getCreatedDate());
        currentRent.setEventCategory(rent.getEventCategory());
        currentRent.setEventName(rent.getEventName());
        currentRent.setRentCancelReason(rent.getRentCancelReason());
        currentRent.setRentCode(rent.getRentCode());
        currentRent.setRentDateStart(rent.getRentDateStart());
        currentRent.setRentDateEnd(rent.getRentDateEnd());
        currentRent.setRenter(rent.getRenter());
        currentRent.setRentEvidencePath(rent.getRentEvidencePath());
        currentRent.setRentLetterPath(rent.getRentLetterPath());
        currentRent.setRentOperationalPrice(rent.getRentOperationalPrice());
        currentRent.setRentPhase(rent.getRentPhase());
        currentRent.setRentPrice(rent.getRentPrice());
        currentRent.setRentRejectReason(rent.getRentRejectReason());
        currentRent.setRentStatus(rent.getRentStatus());
        currentRent.setRoom(rent.getRoom());
        currentRent.setUpdatedBy(rent.getUpdatedBy());
        currentRent.setUpdatedDate(rent.getUpdatedDate());
        currentRent.setUserId(rent.getUserId());
         
        rentService.updateRent(currentRent);
        return new ResponseEntity<Rent>(currentRent, HttpStatus.OK);
    }

    //-------------------Use Case : Menyetujui Penyewaan - Direktur--------------------------------------------------------
    
    @RequestMapping(value = "/rent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Rent> directurRentConfirmation(@PathVariable("id") String id, @RequestBody Rent rent) {
    	Rent currentRent = rentService.getRentByCode(id);
        
        if (currentRent==null) {
            System.out.println("Employee with nip " + id + " not found");
            return new ResponseEntity<Rent>(HttpStatus.NOT_FOUND);
        }
 
        currentRent.setRentPhase(rent.getRentPhase());

        rentService.updateRent(currentRent);
//        Boolean status = true;
        return new ResponseEntity<Rent>(currentRent, HttpStatus.OK);
    }
    
    //-------------------Get Room Status----------------------------------------------------------
    // If no schedule, status = 0
    // If akademik/rent, status = 1
    // If non-akademik, status = 2
    @RequestMapping(value = "/roomStatus", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getRoomStatus(@RequestBody Schedule schedule)
    {
    	Boolean status = true;
    	return new ResponseEntity<Boolean>(status, HttpStatus.OK);
//    	return new ResponseEntity<Boolean>(scheduleService.getRoomStatus(schedule.getIdRoom(), schedule.getDateStart(), schedule.getDateEnd()), HttpStatus.OK);
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
    
    //-------------------Save a Reservation-------------------------------------------------------
    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public ResponseEntity<Void> saveReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder)
    {
    	reservationService.saveReservation(reservation);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/reservation/{id}").buildAndExpand(reservation.getReservationId()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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
