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
        templateUrl: 'partials/Dashboard.html',
        controller: 'DashboardCtrl'
      }).
      when('/login', {
        templateUrl: 'partials/Login.html',
        controller: 'LoginCtrl'
      }).
      when('/reservationForm', {
        templateUrl: 'partials/ReservationForm.html',
        controller: 'ReservationFormCtrl'
      }).
      when('/reservationDetail', {
        templateUrl: 'partials/ReservationDetail.html',
        controller: 'ReservationDetailCtrl'
      }).
      when('/reservationRequestList', {
        templateUrl: 'partials/ReservationRequestList.html',
        controller: 'ReservationRequestListCtrl'
      }).
      when('/reservationRoomSelection', {
        templateUrl: 'partials/ReservationRoomSelection.html',
        controller: 'ReservationRoomSelectionCtrl'
      }).
      when('/rentRequestList', {
        templateUrl: 'partials/RentRequestList.html',
        controller: 'RentRequestListCtrl'
      }).
      when('/rentDetail', {
        templateUrl: 'partials/RentDetail.html',
        controller: 'RentDetailCtrl'
      }).
      when('/rentRoomSelection', {
        templateUrl: 'partials/RentRoomSelection.html',
        controller: 'RentRoomSelectionCtrl'
      }).
      when('/cancelBook', {
        templateUrl: 'partials/CancelReservationForm.html',
        controller: 'FormPembatalanCtrl'
      }).
	  when('/reservationChangeForm', {
        templateUrl: 'partials/ReservationChangeForm.html',
        controller: 'ReservationChangeFormCtrl'
      }).
     when('/pemindahanpenyewaan', {
        templateUrl: 'partials/FormPemindahanPeminjaman.html',
        controller: 'FormPemindahanPenyewaanCtrl'
    }).
    when('/pembatalanpenyewaan', {
        templateUrl: 'partials/FormPembatalanPeminjaman.html',
        controller: 'FormPemindahanPenyewaanCtrl'
    }).
    when('/reservationRequestApprovalList', {
        templateUrl: 'partials/ReservationRequestApprovalList.html',
        controller: 'ReservationRequestApprovalListCtrl'
    }).
    when('/rentRequestApprovalList', {
        templateUrl: 'partials/RentRequestApprovalList.html',
        controller: 'RentRequestApprovalListCtrl'
    }).
    when('/reservationApprovalDetail', {
        templateUrl: 'partials/ReservationApprovalDetail.html',
        controller: 'ReservationApprovalDetailCtrl'
    }).
    when('/rentRejectionDetail', {
        templateUrl: 'partials/RentRejectionDetail.html',
        controller: 'RentRejectionDetailCtrl'
    }).
    when('/rentApprovalDetail', {
        templateUrl: 'partials/RentApprovalDetail.html',
        controller: 'RentApprovalDetailCtrl'
    }).
    when('/reservationRejectionDetail', {
        templateUrl: 'partials/ReservationRejectionDetail.html',
        controller: 'ReservationRejectionDetailCtrl'
    }).
    when('/collidedReservationApprovalDetail', {
        templateUrl: 'partials/CollidedReservationApprovalDetail.html',
        controller: 'CollidedReservationApprovalDetailCtrl'
    }).
    when('/memorandumForm', {
        templateUrl: 'partials/MemorandumForm.html',
        controller: 'MemorandumFormCtrl'
    }).
      otherwise({
        redirectTo: '/dashboard'
      });
  }]);
