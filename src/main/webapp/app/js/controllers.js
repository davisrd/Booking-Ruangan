'use strict';

/* Controllers */

var roomReservationControllers = angular.module('roomReservationControllers', ['ui.bootstrap', 'datatables']);
roomReservationControllers.run(function($rootScope, $uibModal, $location) {
	$rootScope.user = {};
	$rootScope.selectedRent = {};
	$rootScope.selectedReservation = {};
	$rootScope.selectedRoom = {};
	$rootScope.selectedDate = {};
	$rootScope.rent={};
	$rootScope.reservation={};
	
	$rootScope.popup1 = {
		opened: false
	};
	$rootScope.open1 = function() {
		$rootScope.popup1.opened = true;
	};
	$rootScope.popup2 = {
		opened: false
	};
	$rootScope.open2 = function() {
		$rootScope.popup2.opened = true;
	};
		
	$rootScope.dateFormat = 'dd-MMMM-yyyy HH:mm';
	$rootScope.eventCategoryName;
	$rootScope.eventCategoryCode;
	
	$rootScope.$watch('eventCategoryCode', function(newValue, oldValue) {
		if(newValue == 'B') $rootScope.eventCategoryName = 'Bisnis'
		if(newValue == 'N') $rootScope.eventCategoryName = 'Non-Bisnis'
		if(newValue == 'S') $rootScope.eventCategoryName = 'Sosial'
	});
	
	$rootScope.user.userId = 'UMRG0001';
	$rootScope.user.userName = 'Zakiy';
	$rootScope.user.userRole = 'Peminjam';
	
	$rootScope.message = '';
	$rootScope.nextPath = '';
	$rootScope.openMessage = function (controller, message) {
		var modalInstance = $uibModal.open({
		  animation: true,
		  templateUrl: 'partials/MessageModal.html',
		  controller: controller,
		  windowClass: 'center-modal'
		});
	};
	
	$rootScope.goTo = function(path) {
		$location.path(path);
	}
})
.controller('DashboardCtrl', function($rootScope){
	if($rootScope.user.userName == undefined){
		console.log($rootScope.user.username);
		//$rootScope.goTo('/login');
	}
})
.controller('LoginCtrl', function($rootScope, $scope){
	$scope.userLogin = {};
	$scope.login = function(){
		$rootScope.user.userName = $scope.userLogin.username;
		$rootScope.user.password = $scope.userLogin.password;
		$rootScope.goTo('/dashboard');
	}
});

roomReservationControllers.controller('MessageModalCtrl', function($scope, $rootScope, $uibModalInstance, $location) {
	$scope.close = function(){
		$uibModalInstance.close();
		$location.path($rootScope.nextPath);
	}
});

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

roomReservationControllers.controller('ReservationRequestListCtrl', function($scope, $rootScope, Reservation) {
	$scope.listOfReservation = Reservation.query();
	$rootScope.selectedReservation = {};
	$scope.isSelected = function(reservation){
		if($rootScope.selectedReservation == reservation){ 
			return "selected";
		}
		else return '';
	};

	$scope.selectReservation = function(reservation){
		$rootScope.selectedReservation = reservation;
	};
});

roomReservationControllers.controller('ReservationRoomSelectionCtrl', function($scope, $rootScope, Room, $location) {
	$scope.listOfRoom = Room.query();
	$('.clockpicker1').clockpicker()

	$scope.selectRoom = function(room){
		$rootScope.selectedRoom = room;
	};
	
	$scope.validateData = function(path){
		if($rootScope.selectedRoom.roomId != undefined){
			if($rootScope.selectedDate.startDate !=undefined) {
				if($rootScope.selectedDate.endDate !=undefined) {
					$rootScope.selectedDate.startDate = moment($rootScope.selectedDate.startDate).format("DD-MMM-YYYY HH:mm");
					$rootScope.selectedDate.endDate = moment($rootScope.selectedDate.endDate).format("DD-MMM-YYYY HH:mm");
					$location.path(path);
				} else {
					alert('Tanggal selesai harus diisi!');
				}
			} else {
				alert('Tanggal mulai harus diisi!');
			}
		} else {
			alert('Ruangan harus dipilih!');
		}
	}
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

roomReservationControllers.controller('ReservationFormCtrl', function($scope, $rootScope, Reservation) {	
	$scope.reservation = new Reservation();
	$scope.reservation.reservationStartDate = $rootScope.selectedDate.startDate;
	$scope.reservation.reservationEndDate = $rootScope.selectedDate.endDate;
	$scope.reservation.reservationStatus = 'N';
	$scope.reservation.reservationPhase = '1';
	$scope.reservation.room = $scope.room;
	
	$scope.createPeminjam = function(){
		  $scope.reservation.$save(function(){
			alert('sesuatu');  
			goTo('/reservationRequestList');
		  });
	  };
	
	$scope.selectRoom = function(room){
		$rootScope.selectedRoom = room;
	};
});

roomReservationControllers.controller('RentFormCtrl', function($scope, $rootScope, Rent) {
	$scope.rent = new Rent();
	
	$scope.rent.rentStartDate = $rootScope.selectedDate.startDate;
	$scope.rent.rentEndDate = $rootScope.selectedDate.endDate;
	$scope.rent.eventCategory = $rootScope.eventCategoryCode;
	$scope.rent.rentStatus = 'N';
	$scope.rent.rentPhase = '1';

	$scope.rent.room = $scope.room;

	$scope.createRent = function(){
		console.log($scope.rent);
		  $scope.rent.$save(function(){
			alert('sesuatu');  
			goTo('/rentRequestList');
		  });
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

roomReservationControllers.controller('ReservationCancelFormCtrl', function($scope, $rootScope) {
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
roomReservationControllers.controller('RentRequestListCtrl', function($scope, $rootScope, $uibModal, Rent) {
	$scope.listOfRent = Rent.query();
	
	$scope.open = function () {
		var modalInstance = $uibModal.open({
		  animation: $scope.animationsEnabled,
		  templateUrl: 'partials/RentRequestModal.html',
		  controller: 'RentRequestModalCtrl',
		  size: 'xl',
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

roomReservationControllers.controller('RentRoomSelectionCtrl', function($scope, $rootScope, $location, RentRoom, Service) {
	$scope.listOfRoom = RentRoom.query({id:$rootScope.eventCategoryCode});
	
	$scope.selectRoom = function(room){
		$rootScope.selectedRoom = room;
	};

	$scope.validateData = function(path){
		if($rootScope.selectedRoom.roomId != undefined){
			if($rootScope.selectedDate.startDate !=undefined) {
				if($rootScope.selectedDate.endDate !=undefined) {
					$rootScope.selectedDate.startDate = moment($rootScope.selectedDate.startDate).format("DD-MMM-YYYY HH:mm");
					$rootScope.selectedDate.endDate = moment($rootScope.selectedDate.endDate).format("DD-MMM-YYYY HH:mm");
					Service.getRoomAvailibility($rootScope.selectedRoom.roomId, $rootScope.selectedDate.startDate, $rootScope.selectedDate.endDate)
					$location.path(path);
				} else {
					alert('Tanggal selesai harus diisi!');
				}
			} else {
				alert('Tanggal mulai harus diisi!');
			}
		} else {
			alert('Ruangan harus dipilih!');
		}
	}
});

roomReservationControllers.controller('ReservationRequestApprovalListCtrl', function($scope, $rootScope, Reservation) {
	$scope.listOfReservation = Reservation.query();
	
	$scope.selectReservation = function(reservation) {
		$rootScope.selectedReservation = reservation;
	}
});

roomReservationControllers.controller('RentRequestApprovalListCtrl', function($scope, $rootScope, Rent) {
	$scope.listOfRent = Rent.query();
	
	$scope.selectRent = function(rent) {
		console.log(rent)
		$rootScope.selectedRent = rent;
		console.log($rootScope.selectedRent.rentId);
	}
});

roomReservationControllers.controller('MemorandumFormCtrl', function($scope) {
	$scope.memorandum = {};
});

roomReservationControllers.controller('ReservationRejectionDetailCtrl', function($scope, $rootScope) {
	$scope.open = function () {
		$rootScope.message = 'Form sukses disubmit';
		$rootScope.nextPath = '/reservationRequestApprovalList';
		$rootScope.openMessage('MessageModalCtrl');
	};
});

roomReservationControllers.controller('RentRejectionDetailCtrl', function($scope, $rootScope) {
	$scope.open = function () {
		$rootScope.message = 'Form sukses disubmit';
		$rootScope.nextPath = '/rentRequestApprovalList';
		$rootScope.openMessage('MessageModalCtrl');
	};
});

roomReservationControllers.controller('ReservationApprovalDetailCtrl', function($scope, $rootScope) {
	$scope.openApproveEvent = function () {
		$rootScope.message = 'Peminjaman Diizinkan';
		$rootScope.nextPath = '/reservationRequestApprovalList';
		$rootScope.openMessage('MessageModalCtrl');
	};
});

roomReservationControllers.controller('RentApprovalDetailCtrl', function($scope, $rootScope) {
	$scope.openApproveEvent = function () {
		$rootScope.message = 'Penyewaan Diizinkan';
		$rootScope.nextPath = '/rentRequestApprovalList';
		$rootScope.openMessage('MessageModalCtrl');
	};
});

roomReservationControllers.controller('CollidedReservationApprovalDetailCtrl', function($scope, $rootScope) {
	$scope.openRecommendedEvent = function () {
		$rootScope.message = 'Rekomendasi Kegiatan yang diizinkan<br>';
		$rootScope.nextPath = '/collidedReservationApprovalDetail';
		$rootScope.openMessage('MessageModalCtrl');
	};
	
	$scope.openApproveEvent = function () {
		$rootScope.message = 'Peminjaman Diizinkan';
		$rootScope.nextPath = '/reservationRequestApprovalList';
		$rootScope.openMessage('MessageModalCtrl');
	};
});

roomReservationControllers.controller('RoomScheduleSelectionCtrl', function($scope, $rootScope, Room) {
	var vm = this;

    //These variables MUST be set as a minimum for the calendar to work
    vm.calendarView = 'month';
    vm.viewDate = new Date();
    vm.events = [
      {
        title: 'An event',
        type: 'warning',
        startsAt: moment().startOf('week').subtract(2, 'days').add(8, 'hours').toDate(),
        endsAt: moment().startOf('week').add(1, 'week').add(9, 'hours').toDate(),
        draggable: true,
        resizable: true
      }, {
        title: '<i class="glyphicon glyphicon-asterisk"></i> <span class="text-primary">Another event</span>, with a <i>html</i> title',
        type: 'info',
        startsAt: moment().subtract(1, 'day').toDate(),
        endsAt: moment().add(5, 'days').toDate(),
        draggable: true,
        resizable: true
      }, {
        title: 'This is a really long event title that occurs on every year',
        type: 'important',
        startsAt: moment().startOf('day').add(7, 'hours').toDate(),
        endsAt: moment().startOf('day').add(19, 'hours').toDate(),
        recursOn: 'year',
        draggable: true,
        resizable: true
      }
    ];

    vm.isCellOpen = true;

    vm.eventClicked = function(event) {
      alert.show('Clicked', event);
    };

    vm.eventEdited = function(event) {
      alert.show('Edited', event);
    };

    vm.eventDeleted = function(event) {
      alert.show('Deleted', event);
    };

    vm.eventTimesChanged = function(event) {
      alert.show('Dropped or resized', event);
    };

    vm.toggle = function($event, field, event) {
      $event.preventDefault();
      $event.stopPropagation();
      event[field] = !event[field];
    };
});

// $location.path( '/new-page.html' ); fungsi buat pindah page. bisi ada yg butuh