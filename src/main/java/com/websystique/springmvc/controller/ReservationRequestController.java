package com.websystique.springmvc.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.leftproject.model.Rent;
import com.leftproject.model.Reservation;
import com.leftproject.model.Room;
import com.leftproject.model.User;
import com.websystique.springmvc.service.ReservationService;
import com.websystique.springmvc.service.RoomService;
import com.websystique.springmvc.service.ScheduleService;
import com.websystique.springmvc.service.UserService;

@RestController
public class ReservationRequestController {
	
	@Autowired
	ReservationService reservationService;
	@Autowired
	RoomService roomService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	UserService userService;
	
	//-------------------Use Case : Mengajukan Peminjaman--------------------------------------------------------

    @RequestMapping(value = "/reservation/room/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Room>> getAllReservableRoom(@PathVariable("category") String category) {
    	List<Room> rooms = roomService.getRentRoomByCategory(category); // With condition it should be
        if(rooms.isEmpty()){
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/rent/roomAvailibility/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getRoomAvailibility(@PathVariable("id") String id, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException {
    	System.out.println(startDate);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	Integer status = scheduleService.getRentRoomAvailability(id, df.parse(startDate), df.parse(endDate)); // With condition it should be
//        Boolean status = true;
//    	if(status==false){
//            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
        return new ResponseEntity<Integer>(status, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getAllReservation(@RequestParam("userId") String userId) {
    	User user = userService.findById(userId);
    	if(user != null){
	        List<Reservation> reservations = reservationService.getAllReservation(user);
	        if(reservations.isEmpty()){
	            return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);
    	}
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public ResponseEntity<Void> saveReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder)
    {
    	System.out.println("Create Rent with eventName : " + reservation.getEventName());
    	reservationService.saveReservation(reservation);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/reservation/{id}").buildAndExpand(reservation.getReservationCode()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
//
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Reservation> saveRent(@PathVariable("id") String id, @RequestBody Reservation reservation, UriComponentsBuilder ucBuilder)
    {
    	System.out.println("Updating Employee " + id);
        
    	Reservation currentReservation = reservationService.getReservationByCode(id);
         
        if (currentReservation==null) {
            System.out.println("Reservation with id " + id + " not found");
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

}
