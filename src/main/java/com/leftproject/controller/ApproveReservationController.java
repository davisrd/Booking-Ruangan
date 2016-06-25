package com.leftproject.controller;

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

import com.leftproject.model.Reservation;
import com.leftproject.model.Room;
import com.leftproject.model.User;
import com.leftproject.service.ReservationService;
import com.leftproject.service.RoomService;
import com.leftproject.service.ScheduleService;
import com.leftproject.service.UserService;

import com.leftproject.model.Reservation;

public class ApproveReservationController {
	@Autowired
	ReservationService reservationService;
	
	
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
    
}
