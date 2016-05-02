'use strict';

/* App Module */

var roomReservationApp = angular.module('roomReservationApp', [
  'ngRoute',
  'roomReservationAnimations',
  'roomReservationControllers',
  'roomReservationFilters',
  'roomReservationServices'
]);

roomReservationApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/dashboard', {
        templateUrl: 'partials/dashboard.html'
      }).
      when('/reservationForm', {
        templateUrl: 'partials/ReservationForm.html',
        controller: 'FormReservationCtrl'
      }).
      when('/reservationDetail', {
        templateUrl: 'partials/ReservationDetail.html',
        controller: 'ReservationDetailCtrl'
      }).
      when('/reservationRequestList', {
        templateUrl: 'partials/ReservationRequestList.html',
        controller: 'ReservationRequestListCtrl'
      }).
      when('/rentDetail', {
        templateUrl: 'partials/RentDetail.html',
        controller: 'RentDetailCtrl'
      }).
      when('/daftarRuangan', {
        templateUrl: 'partials/RoomSelectScreen.html',
        controller: 'PilihRuanganCtrl'
      }).
      when('/cancelBook', {
        templateUrl: 'partials/CancelReservationForm.html',
        controller: 'FormPembatalanCtrl'
      }).
	  when('/pemindahanpeminjaman', {
        templateUrl: 'partials/FormPemindahanPeminjaman.html',
        controller: 'FormPemindahanPeminjamanCtrl'
      }).
      otherwise({
        redirectTo: '/dashboard'
      });
  }]);
