'use strict';

App.controller('PeminjamanController', ['$scope', 'Peminjaman', 'Peminjam', 'Ruangan', function($scope, Peminjaman, Peminjam, Ruangan) {
          $scope.isEdit = false;
		  var self = this;
          self.peminjaman= new Peminjaman();
          
          self.peminjamans=[];
          self.peminjams=[];
          self.ruangans=[];
              
          self.fetchAllPeminjamans = function(){
        	  self.peminjamans = Peminjaman.query();
          };
              
          self.fetchAllPeminjams = function(){
        	  self.peminjams = Peminjam.query();
          };
              
          self.fetchAllRuangans = function(){
        	  self.ruangans = Ruangan.query();
          };
           
          self.createPeminjaman = function(){
        	  self.peminjaman.$save(function(){
        		  self.fetchAllPeminjamans();
        	  });
          };

          self.updatePeminjaman = function(){
        	  self.peminjaman.$update(function(){
    			  self.fetchAllPeminjamans();
    		  });
          };

         self.deletePeminjaman = function(identity){
        	 var peminjaman = Peminjaman.get({id:identity}, function() {
        		  peminjaman.$delete(function(){
        			  console.log('Deleting peminjaman with id ', identity);
        			  self.fetchAllPeminjamans();
        		  });
        	 });
          };

          self.fetchAllPeminjamans();
          self.fetchAllPeminjams();
          self.fetchAllRuangans();

          self.submit = function() {
              if($scope.isEdit==false){
                  console.log('Saving New Peminjaman', self.peminjaman);    
                  self.createPeminjaman();
              }else{
    			  console.log('Updating peminjaman with id ', self.peminjaman.id);   
                  self.updatePeminjaman();
                  console.log('Peminjaman updated with id ', self.peminjaman.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.peminjamans.length; i++){
                  if(self.peminjamans[i].id === id) {
                     self.peminjaman = angular.copy(self.peminjamans[i]);
                     break;
                  }
              }
			  $scope.isEdit = true;
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.peminjaman.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deletePeminjaman(id);
          };
          
          self.reset = function(){
              self.peminjaman= new Peminjaman();
              $scope.myForm.$setPristine(); //reset Form
          };

          self.selected = function(){
        	  if(self.peminjaman.peminjam != '') return "select";
        	  else return "";
          }
      }]);
