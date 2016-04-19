'use strict';

/* Controllers */

var roomReservationControllers = angular.module('roomReservationControllers', []);
roomReservationControllers.run(function($rootScope) {
	$rootScope.user = {};
	$rootScope.user.nim = '131524028';
	$rootScope.user.userName = 'ZakiyCute';
	$rootScope.user.userRole = 'Peminjam';
	
})
roomReservationControllers.controller('PhoneListCtrl', ['$scope', 'Phone',
  function($scope, Phone) {
    $scope.phones = Phone.query();
    $scope.orderProp = 'age';
  }]);

roomReservationControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone',
  function($scope, $routeParams, Phone) {
    $scope.phone = Phone.get({phoneId: $routeParams.phoneId}, function(phone) {
      $scope.mainImageUrl = phone.images[0];
    });

    $scope.setImage = function(imageUrl) {
      $scope.mainImageUrl = imageUrl;
    };
  }]);

roomReservationControllers.controller('DaftarPengajuanCtrl', function($scope, $rootScope) {
	$scope.listOfReservation = [{
		reservationId: 1,
		eventUserName: "Himakom",
		reservationStartDate: "18 April 2016 10:00",
		reservationEndDate: "18 April 2016 17:00",
		facility: {
			facilityId: 1,
			facilityName: "RSG"
		},
		eventName: "Studi Banding",
		reservationStatus: true
	},{
		reservationId: 2,
		eventUserName: "Himakaps",
		reservationStartDate: "19 April 2016 10:00",
		reservationEndDate: "20 April 2016 10:00",
		facility: {
			facilityId: 2,
			facilityName: "Pendopo"
		},
		eventName: "Seminar",
		reservationStatus: true
	},{
		reservationId: 3,
		eventUserName: "Himakom",
		reservationStartDate: "30 April 2016 08:00",
		reservationEndDate: "30 April 2016 21:00",
		facility: {
			facilityId: 3,
			facilityName: "Student Center"
		},
		eventName: "Pelatihan",
		reservationStatus: true
	}];

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
});

roomReservationControllers.controller('PilihRuanganCtrl', function($scope, $rootScope) {
	$scope.listOfFacility = [{
		facilityId: 1,
		facilityName: "Ruangan Utama Pendopo Agung",
		facilityType: "Umum"
	},{
		facilityId: 2,
		facilityName: "Student Center",
		facilityType: "Umum"
	},{
		facilityId: 3,
		facilityName: "GKB",
		facilityType: "Umum"
	},{
		facilityId: 4,
		facilityName: "Conference Room P2T",
		facilityType: "Umum"
	},{
		facilityId: 5,
		facilityName: "Conference Room Direktorat",
		facilityType: "Umum"
	}];

	$scope.selectFacility = function(facility){
		$rootScope.selectedFacility = facility;
	};
});


roomReservationControllers.controller('FormPembatalanCtrl', function($scope, $rootScope) {
	$scope.reservation = {
		reservationId: 1,
		eventUserName: "Himakom",
		reservationStartDate: "17-04-2016",
		reservationEndDate: "20-04-2016",
		facility: {
			facilityId: 1,
			facilityName: "RSG",
			facilityType: "Diijinkan"
		},
		eventName: "Studi Banding",
		eventType: "Studi Banding",
		reservationStatus: true
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
});

roomReservationControllers.controller('FormPemindahanPeminjamanCtrl', function($scope, $rootScope) {
	$scope.reservation = {
		reservationId: 1,
		eventUserName: "Himakom",
		reservationStartDate: "17-04-2016",
		reservationEndDate: "20-04-2016",
		facility: {
			facilityId: 1,
			facilityName: "RSG",
			facilityType: "Diijinkan"
		},
		eventName: "Studi Banding",
		eventType: "Studi Banding",
		reservationStatus: true
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
})
roomReservationControllers.controller('FormReservationCtrl', function($scope, $rootScope) {
	$scope.facility = {
		facilityId: 1,
		facilityName: "Ruangan Utama Pendopo Agung",
		facilityType: "Umum"
	};
	$scope.reservation = {};
	$scope.reservation.reservationStartDate = "17 April 2015 10:00";
	$scope.reservation.reservationEndDate = "17 April 2015 17:00";
	$scope.reservation.facility = $scope.facility;
	$scope.selectFacility = function(facility){
		$rootScope.selectedFacility = facility;
	};
});
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
		facility: {
			facilityId: 1,
			facilityName: "RSG",
			facilityType: "Fasilitas Umum"
		},
		reservationStatus: "Diizinkan"
		
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
})