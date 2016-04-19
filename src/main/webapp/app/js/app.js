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
        templateUrl: 'partials/dashboard.html',
        /*controller: 'PhoneListCtrl'*/
      }).
      when('/reservationForm', {
        templateUrl: 'partials/ReservationForm.html',
        controller: 'FormReservationCtrl'
      }).
      when('/reservationDetail', {
        templateUrl: 'partials/ReservationDetail.html',
        controller: 'ReservationDetailCtrl'
      }).
      when('/reservationList', {
        templateUrl: 'partials/DaftarPengajuan.html',
        controller: 'DaftarPengajuanCtrl'
      }).
      when('/daftarRuangan', {
        templateUrl: 'partials/PilihRuangan.html',
        controller: 'PilihRuanganCtrl'
      }).
      when('/cancelBook', {
        templateUrl: 'partials/FormPembatalan.html',
        controller: 'FormPembatalanCtrl'
      }).
	  when('/pemindahanpeminjaman', {
        templateUrl: 'partials/FormPemindahanPeminjaman.html',
        controller: 'FormPemindahanPeminjamanCtrl'
      }).
      otherwise({
        redirectTo: '/reservationForm'
      });
  }]);
