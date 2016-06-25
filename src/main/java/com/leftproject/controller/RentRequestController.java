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

import com.leftproject.model.Rent;
import com.leftproject.model.Reservation;
import com.leftproject.model.Room;
import com.leftproject.model.User;
import com.leftproject.service.RentService;
import com.leftproject.service.RoomService;
import com.leftproject.service.ScheduleService;
import com.leftproject.service.UserService;

@RestController
public class RentRequestController {
	
	@Autowired
	RentService rentService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	ScheduleService scheduleService;
	
	//-------------------Use Case : Mengajukan Penyewaan--------------------------------------------------------

    @RequestMapping(value = "/rent/room/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Room>> getAllRentableRoom(@PathVariable("category") String category) {
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
}
