'use strict';

/* Controllers */

var roomReservationControllers = angular.module('roomReservationControllers', ['ui.bootstrap']);
roomReservationControllers.run(function($rootScope) {
	$rootScope.user = {};
	$rootScope.rent = {};
	$rootScope.reservation = {};
	
	$rootScope.dateFormat = 'dd-MMMM-yyyy';
	$rootScope.eventCategoryName;
	$rootScope.eventCategoryCode;
	
	$rootScope.$watch('eventCategoryCode', function(newValue, oldValue) {
		if(newValue == 1) $rootScope.eventCategoryName = 'Bisnis'
		if(newValue == 2) $rootScope.eventCategoryName = 'Non-Bisnis'
		if(newValue == 3) $rootScope.eventCategoryName = 'Sosial'
	});
	$rootScope.user.userId = 'UST00001';
	$rootScope.user.userName = 'Zakiy';
	$rootScope.user.userRole = 'Peminjam';
	
	
	
	
})
roomReservationControllers.controller('navigationTemplateCtrl',function($scope) {
    $scope.navBar = 1;
	
	$scope.selectNavBar = function(navBarCode){
		$scope.navBar = navBarCode;
	}
	
	$scope.isActive = function(navBarCode){
		if( $scope.navBar == navBarCode) return 'active';
		else return '';
	}
  });

roomReservationControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone',
  function($scope, $routeParams, Phone) {
    $scope.phone = Phone.get({phoneId: $routeParams.phoneId}, function(phone) {
      $scope.mainImageUrl = phone.images[0];
    });

    $scope.setImage = function(imageUrl) {
      $scope.mainImageUrl = imageUrl;
    };
  }]);

roomReservationControllers.controller('ReservationRequestListCtrl', function($scope, $rootScope) {
	$scope.listOfReservation = [{
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

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
});

roomReservationControllers.controller('ReservationRoomSelectionCtrl', function($scope, $rootScope) {
	$scope.listOfRoom = [{
		roomId: 1,
		roomName: "Ruangan Utama Pendopo Agung",
		roomType: "Umum"
	},{
		roomId: 2,
		roomName: "Student Center",
		roomType: "Umum"
	},{
		roomId: 3,
		roomName: "GKB",
		roomType: "Umum"
	},{
		roomId: 4,
		roomName: "Conference Room P2T",
		roomType: "Umum"
	},{
		roomId: 5,
		roomName: "Conference Room Direktorat",
		roomType: "Umum"
	}];

	$scope.selectRoom = function(room){
		$rootScope.selectedRoom = room;
	};
});


roomReservationControllers.controller('FormPembatalanCtrl', function($scope, $rootScope) {
	$scope.reservation = {
		reservationId: 1,
		eventUserName: "Himakom",
		reservationStartDate: "17-04-2016",
		reservationEndDate: "20-04-2016",
		room: {
			roomId: 1,
			roomName: "RSG",
			roomType: "Diijinkan"
		},
		eventName: "Studi Banding",
		eventType: "Studi Banding",
		reservationStatus: true
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
});

roomReservationControllers.controller('ReservationFormCtrl', function($scope, $rootScope) {
	$scope.room = {
		roomId: 1,
		roomName: "Ruangan Utama Pendopo Agung",
		roomType: "Umum"
	};
	$scope.reservation = {};
	$scope.reservation.reservationStartDate = "17 April 2015 10:00";
	$scope.reservation.reservationEndDate = "17 April 2015 17:00";
	$scope.reservation.room = $scope.room;
	$scope.selectRoom = function(room){
		$rootScope.selectedRoom = room;
	};
});

roomReservationControllers.controller('ReservationChangeFormCtrl', function($scope, $rootScope) {
	$scope.reservation = {
		reservationId: 1,
		eventUserName: "Himakom",
		reservationStartDate: "17-04-2016",
		reservationEndDate: "20-04-2016",
		room: {
			roomId: 1,
			roomName: "RSG",
			roomType: "Diijinkan"
		},
		eventName: "Studi Banding",
		eventType: "Studi Banding",
		reservationStatus: true
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
})

roomReservationControllers.controller('ReservationDetailCtrl', function($scope, $rootScope) {
	$scope.reservation = {
		reservationId: 1,
		eventUserName: "Himakom",
		reservationStartDate: "17-04-2016",
		reservationEndDate: "20-04-2016",
		eventName: "Seminar International",
		eventType: "Kegiatan Mahasiswa",
		eventScale: "International",
		totalAudience : "200 orang",
		room: {
			roomId: 1,
			roomName: "RSG",
			roomType: "Fasilitas Umum"
		},
		reservationStatus: "Diizinkan"
		
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
})

roomReservationControllers.controller('RentDetailCtrl', function($scope, $rootScope) {
	$scope.rent = {
		rentId: 1,
		eventUserName: "Himakom",
		rentStartDate: "17-04-2016",
		rentEndDate: "20-04-2016",
		eventName: "Seminar International",
		eventType: "Kegiatan Mahasiswa",
		room: {
			roomId: 1,
			roomName: "RSG",
			roomType: "Fasilitas Umum"
		},
		rentStatus: "Diizinkan",
		rentPrice: "200000"
	};

	$scope.selectRent = function(rent){
		$rootScope.selectedRent = rent;
	};
})

roomReservationControllers.controller('FormPemindahanPenyewaanCtrl', function($scope, $rootScope) {
	$scope.reservation = {
		reservationId: 1,
		eventUserName: "Jaki",
		reservationStartDate: "18-04-2016",
		reservationEndDate: "18-04-2016",
		eventName: "Pernikahan",
		eventType: "Diijinkan",
		facility: {
			facilityId: 1,
			facilityName: "Ruang Utama Pendopo Agung",
			facilityPrice: "10.000.000"
		},
		eventName: "Studi Banding",
		eventType: "Studi Banding",
		reservationStatus: true
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
});
roomReservationControllers.controller('FormPemPenyewaanCtrl', function($scope, $rootScope) {
	$scope.reservation = {
		reservationId: 1,
		eventUserName: "Jaki",
		reservationStartDate: "18-04-2016",
		reservationEndDate: "18-04-2016",
		eventName: "Pernikahan",
		eventType: "Diijinkan",
		facility: {
			facilityId: 1,
			facilityName: "Ruang Utama Pendopo Agung",
			facilityPrice: "10.000.000"
		},
		eventName: "Studi Banding",
		eventType: "Studi Banding",
		reservationStatus: true
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
});
roomReservationControllers.controller('RentRequestListCtrl', function($scope, $rootScope, $uibModal) {
	$scope.listOfRent = [{
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
	
	$scope.open = function () {
		var modalInstance = $uibModal.open({
		  animation: $scope.animationsEnabled,
		  templateUrl: 'partials/RentRequestModal.html',
		  controller: 'RentRequestModalCtrl',
		  size: 'sm'
		});
	};
	
	$scope.isSelected = false;
	
	$scope.selectRent = function(rent){
		$rootScope.selectedRent = rent;
		$scope.isSelected = true;
	};
});

roomReservationControllers.controller('RentRequestModalCtrl', function($scope, $rootScope, $uibModalInstance) {
	$scope.setRentType = function(eventCategory){
		$rootScope.rent.eventCategory = eventCategory;
		$rootScope.eventCategoryCode = eventCategory;
		$uibModalInstance.close();
	}
});

roomReservationControllers.controller('RentRoomSelectionCtrl', function($scope, $rootScope) {
	$scope.listOfRoom = [{
		roomId: 1,
		roomName: "Ruangan Utama Pendopo Agung",
		roomType: "Umum"
	},{
		roomId: 2,
		roomName: "Student Center",
		roomType: "Umum"
	},{
		roomId: 3,
		roomName: "GKB",
		roomType: "Umum"
	},{
		roomId: 4,
		roomName: "Conference Room P2T",
		roomType: "Umum"
	},{
		roomId: 5,
		roomName: "Conference Room Direktorat",
		roomType: "Umum"
	}];
	
	$scope.popup1 = {
		opened: false
	};
	$scope.open1 = function() {
		$scope.popup1.opened = true;
	};
	$scope.popup2 = {
		opened: false
	};
	$scope.open2 = function() {
		$scope.popup2.opened = true;
	};
	
	$scope.selectRoom = function(room){
		$rootScope.selectedRoom = room;
	};
});

