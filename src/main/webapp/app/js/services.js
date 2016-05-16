'use strict';

/* Services */

var roomReservationServices = angular.module('roomReservationServices', ['ngResource']);

roomReservationServices.factory('Phone', ['$resource',
  function($resource){
    return $resource('phones/:phoneId.json', {}, {
      query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
    });
  }])
  
  .factory('Reservation', function(){
	  var listOfReservation = [{
		reservationId: 1,
		eventUserName: "Himakom",
		reservationStartDate: "18 April 2016 10:00",
		reservationEndDate: "18 April 2016 17:00",
		room: {
			roomId: 1,
			roomName: "RSG"
		},
		eventName: "Studi Banding",
		reservationStatus: true
	},{
		reservationId: 2,
		eventUserName: "Himakaps",
		reservationStartDate: "19 April 2016 10:00",
		reservationEndDate: "20 April 2016 10:00",
		room: {
			roomId: 2,
			roomName: "Pendopo"
		},
		eventName: "Seminar",
		reservationStatus: true
	},{
		reservationId: 3,
		eventUserName: "Himakom",
		reservationStartDate: "30 April 2016 08:00",
		reservationEndDate: "30 April 2016 21:00",
		room: {
			roomId: 3,
			roomName: "Student Center"
		},
		eventName: "Pelatihan",
		reservationStatus: true
	}];
	
	return listOfReservation;
  })
  
  .factory('Rent', function(){
	  var listOfRent = [{
		rentId: 1,
		eventUserName: "Himakom",
		rentStartDate: "18 April 2016 10:00",
		rentEndDate: "18 April 2016 17:00",
		room: {
			roomId: 1,
			roomName: "RSG"
		},
		eventName: "Studi Banding",
		rentStatus: true
	},{
		rentId: 2,
		eventUserName: "Himakaps",
		rentStartDate: "19 April 2016 10:00",
		rentEndDate: "20 April 2016 10:00",
		room: {
			roomId: 2,
			roomName: "Pendopo"
		},
		eventName: "Seminar",
		rentStatus: true
	},{
		rentId: 3,
		eventUserName: "Himakom",
		rentStartDate: "30 April 2016 08:00",
		rentEndDate: "30 April 2016 21:00",
		room: {
			roomId: 3,
			roomName: "Student Center"
		},
		eventName: "Pelatihan",
		rentStatus: true
	}];
	
	return listOfRent;
  })
  
  .factory('Room', function($resource){
	  
	  // return $resource(
   //  		'http://localhost:8080/SpringHibernateRuangan/ruangan/:id', 
   //  		{id: '@id'},//Handy for update & delete. id will be set with id of instance
   //  		{
   //  			update: {
   //  			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
   //  			}
    			
   //  		}
   	//	);
   	var room = [{
   		roomId: 1,
		roomName: "Pendopo",
		roomType: "Fasilitas Umum"
	},
	{
		roomId: 2,
		roomName: "Student Center",
		roomType: "Fasilitas Umum"	
	},
	{
		roomId: 3,
		roomName: "Converence Room",
		roomType: "Fasilitas Umum"
	},
	{
		roomId: 4,
		roomName: "RSG JTK",
		roomType: "Fasilitas Khusus"
	},
	{
		roomId: 5,
		roomName: "GKB",
		roomType: "Fasilitas Khusus"
	}]
	return room;
  });
