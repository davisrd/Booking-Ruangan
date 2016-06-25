'use strict';

/* Services */

var roomReservationServices = angular.module('roomReservationServices', ['ngResource']);

roomReservationServices.factory('Phone', ['$resource',
  function($resource){
    return $resource('phones/:phoneId.json', {}, {
      query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
    });
  }])
  
	.factory('User', function($resource, $rootScope){
		console.log($rootScope.user.userCode);
		return $resource(
			'http://localhost:8080/ProyekRuangan/user/:id',
			{id: '@userCode'},
			{
				login: {
					method: 'GET',
					params: {
	         			userCode: $rootScope.user.userCode,
	         			userPassword: $rootScope.user.userPassword
					}
				}
			}
		);
	})

  .factory('Reservation', function($resource, $rootScope){
	  return $resource(
     		'http://localhost:8080/ProyekRuangan/reservation/:id', 
     		{id: '@reservationCode'},//Handy for update & delete. id will be set with id of instance
     		{
     			update: {
     			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
     			},
				query: {
					method: 'GET',
					params: {
	         				userCode: $rootScope.user.userCode
					},
	       				isArray:true
				}
    			
     		}
   		);
		/*
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
	
	return listOfReservation; */
  })
  
  .factory('Rent', function($resource){
	  return $resource(
     		'http://localhost:8080/ProyekRuangan/rent/:id', 
     		{id: '@rentCode'},//Handy for update & delete. id will be set with id of instance
     		{
     			update: {
     			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
     			}
    			
     		}
   		);
  })
  
  .factory('Room', function($resource){
	  
	   return $resource(
     		'http://localhost:8080/ProyekRuangan/room/:id', 
     		{id: '@id'},//Handy for update & delete. id will be set with id of instance
     		{
     			update: {
     			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
     			}
    			
     		}
   		);
   	/*var room = [{
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
	return room; */
  })
  
  .factory('RentRoom', function($resource){
	  
	   return $resource(
     		'http://localhost:8080/ProyekRuangan/rent/room/:id', 
     		{id: '@id'},//Handy for update & delete. id will be set with id of instance
     		{
     			update: {
     			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
     			}
    			
     		}
   		);
  })
  .factory('Service', function($resource, $http){
  		var urlBase = 'http://localhost:8080/ProyekRuangan'; //get?model=userDetail&userid=123123123;
	    return {
	    	getUser: function(userCode, userPassword) {
				var params = {
	        		userCode: userCode,
	        		userPassword: userPassword
	        	}
	        	return $http({
				    url: urlBase + '/user', 
				    method: "GET",
				    params: params
				 })
	    	},
	        getRentRoomAvailibility: function(roomId, startDate, endDate) {
	        	var params = {
	        		startDate: startDate,
	        		endDate: endDate
	        	}
	        	return $http({
				    url: urlBase + '/rent/roomAvailibility/' + roomId, 
				    method: "GET",
				    params: params
				 })
	        },
	        getReservationRoomAvailibility: function(roomId, startDate, endDate) {
	        	var params = {
	        		startDate: startDate,
	        		endDate: endDate
	        	}
	        	console.log(params);
	        	return $http({
				    url: urlBase + '/reservation/roomAvailibility/' + roomId, 
				    method: "GET",
				    params: params
				 })
	        },
	        getRentApprovalList: function() {
	        	var params = {
	        		rentStatus: 'N'
	        	}
	        	return $http({
				    url: urlBase + '/rentApproval', 
				    method: "GET",
				    params: params
				 }).then(function success(data) {
                	console.log(data);
                }, function error(error){
                    console.log(error);
                });
			},
			getReservationRoom: function(){
				return $http({
				    url: urlBase + '/reservation/room', 
				    method: "GET"
				 });
			},
			updateReservation: function(reservationCode){
				return $http({
				    url: urlBase + '/reservation/' + reservationCode, 
				    method: "PUT"
				 });
			}
	    }
	});