package com.leftproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leftproject.model.Reservation;
import com.leftproject.model.User;
import com.leftproject.service.ReservationService;
import com.leftproject.service.UserService;

@RestController
public class ApproveReservationController {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	UserService userService;
	
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
    
    @RequestMapping(value = "/reservationApprove", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> getAllReservation(@RequestParam("userCode") String userCode) {
    	User user = userService.findById(userCode);
    	if(user != null){
    		System.out.print(user.getUserCode().substring(0,4));
    		char phase = '0';
    		if(user.getUserCode().substring(0,4).equals("UMRG"))
    			phase = '1';
    		else if(user.getUserCode().substring(0,4).equals("UMRS"))
    			phase = '2';
	        List<Reservation> reservations = reservationService.getReservationByPhase(phase,user);
	        if(reservations.isEmpty()){
	            return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);
    	}
    }
    
}
