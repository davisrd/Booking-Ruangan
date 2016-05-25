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

@Controller
@RequestMapping("/")
public class AppController {
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
    public ResponseEntity<List<Room>> getAllRentableRoom(@PathVariable("category") String category) {
    	List<Room> rooms = roomService.getRentRoomByCategory(category); // With condition it should be
        if(rooms.isEmpty()){
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/roomAvailibility/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getRoomAvailibility(@PathVariable("id") String id, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
    	System.out.println(startDate);
    	Boolean status = scheduleService.getRentRoomAvailability(id, startDate, endDate); // With condition it should be
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
//
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
        currentRent.setUser(rent.getUser());
         
        rentService.updateRent(currentRent);
        return new ResponseEntity<Rent>(currentRent, HttpStatus.OK);
    }

    //-------------------Use Case : Menyetujui Penyewaan - Direktur--------------------------------------------------------
    
    @RequestMapping(value = "/rentApprove/{id}", method = RequestMethod.PUT)
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
    
    
    //-------------------Save a Reservation-------------------------------------------------------
    
  /*  
    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public ResponseEntity<Void> saveReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder)
    {
    	reservationService.saveReservation(reservation);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/reservation/{id}").buildAndExpand(reservation.getReservationCode()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  */
    //------------------Use Case: Mengajukan Peminjaman-----------------------------------
    @RequestMapping(value = "/reservationRoom", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Room>> getAllReservationableRoom() {
    	List<Room> rooms = roomService.getReservationRoom(); // With condition it should be
        if(rooms.isEmpty()){
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/roomAvailibility/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getReservationRoomAvailibility(@PathVariable("id") String id, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
    	System.out.println(startDate);
    	Boolean status = scheduleService.getReservationRoomAvailability(id, startDate, endDate); // With condition it should be
//        Boolean status = true;
    	if(status==false){
            return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getAllReservation() {
        List<Reservation> reservations = reservationService.getProposedReservation();
        if(reservations.isEmpty()){
            return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public ResponseEntity<Void> saveReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder)
    {
    	reservationService.saveReservation(reservation);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/reservation/{id}").buildAndExpand(reservation.getReservationCode()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Reservation> saveReservation(@PathVariable("id") String id, @RequestBody Reservation reservation, UriComponentsBuilder ucBuilder)
    {
    	System.out.println("Updating Employee " + id);
        
        Reservation currentReservation = reservationService.getReservationByCode(id);
         
        if (currentReservation==null) {
            System.out.println("Employee with nip " + id + " not found");
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
		currentReservation.setReservationCode(reservation.getReservationCode());
		currentReservation.setReservationDateStart(reservation.getReservationDateStart());
		currentReservation.setReservationDateEnd(reservation.getReservationDateEnd());
		currentReservation.setCreatedDate(reservation.getCreatedDate());
		currentReservation.setReservationStatus(reservation.getReservationStatus());
		currentReservation.setReservationPhase(reservation.getReservationPhase());
		currentReservation.setReservationFilePath(reservation.getReservationFilePath());
		currentReservation.setReservationOperationalPrice(reservation.getReservationOperationalPrice());
		currentReservation.setReservationRejectReason(reservation.getReservationRejectReason());
		currentReservation.setReservationCancelReason(reservation.getReservationCancelReason());
		currentReservation.setEventType(reservation.getEventType());
		currentReservation.setEventName(reservation.getEventName());
		currentReservation.setEventScale(reservation.getEventScale());
		currentReservation.setEventTotalParticipant(reservation.getEventTotalParticipant());
		currentReservation.setUser(reservation.getUser());
		currentReservation.setRoom(reservation.getRoom());
		currentReservation.setUpdatedBy(reservation.getUpdatedBy());
		currentReservation.setUpdatedDate(reservation.getUpdatedDate());
         
        reservationService.updateReservation(currentReservation);
        return new ResponseEntity<Reservation>(currentReservation, HttpStatus.OK);
    }
    
 //-------------------Use Case : Menyetujui Peminjaman - Kasubag TU--------------------------------------------------------
    
    @RequestMapping(value = "/reservationApprove/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Reservation> kasubbagTUReseervationConfirmation(@PathVariable("id") String id, @RequestBody Reservation reservation) {
    	Reservation currentReservation = reservationService.getReservationByCode(id);
        
        if (currentReservation==null) {
            System.out.println("Reservation with ID " + id + " not found");
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
 
        currentReservation.setReservationPhase(reservation.getReservationPhase());

        reservationService.updateReservation(currentReservation);
//        Boolean status = true;
        return new ResponseEntity<Reservation>(currentReservation, HttpStatus.OK);
    }
    
  //-------------------------Cancel Reservation ----------------------------------------------
  	@RequestMapping(value = "/cancelReservation", method = RequestMethod.PUT)
      public ResponseEntity<Void> cancelReservation(@RequestBody Reservation reservation)
      {
      	reservationService.cancelReservation(reservation);

      	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
      }
  	
  	
  //---------------------------Cancel Rent-------------------------------------
  	@RequestMapping(value = "/cancelRent", method = RequestMethod.PUT)
      public ResponseEntity<Void> cancelRent(@RequestBody Rent rent)
      {
      	rentService.cancelRent(rent);

      	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
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
