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
      when('/phones', {
        templateUrl: 'partials/phone-list.html',
        controller: 'PhoneListCtrl'
      }).
      when('/phones/:phoneId', {
        templateUrl: 'partials/phone-detail.html',
        controller: 'PhoneDetailCtrl'
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
        redirectTo: '/reservationList'
      });
  }]);
