'use strict';

App.controller('PeminjamController', ['$scope', 'Peminjam', function($scope, Peminjam) {
		$scope.Manggil = function(){
			alert(self.peminjam);
			console.log(self.peminjams);
		};
          $scope.isEdit = false;
		  var self = this;
          self.peminjam= new Peminjam();
          
          self.peminjams=[];
              
          self.fetchAllPeminjams = function(){
        	  self.peminjams = Peminjam.query();
          };
           
          self.createPeminjam = function(){
        	  self.peminjam.$save(function(){
        		  self.fetchAllPeminjams();
        	  });
          };

          self.updatePeminjam = function(){
        	  self.peminjam.$update(function(){
    			  self.fetchAllPeminjams();
    		  });
          };

         self.deletePeminjam = function(identity){
        	 var peminjam = Peminjam.get({id:identity}, function() {
        		  peminjam.$delete(function(){
        			  console.log('Deleting peminjam with id ', identity);
        			  self.fetchAllPeminjams();
        		  });
        	 });
          };

          self.fetchAllPeminjams();

          self.submit = function() {
              if($scope.isEdit==false){
                  console.log('Saving New Peminjam', self.peminjam);    
                  self.createPeminjam();
              }else{
    			  console.log('Updating peminjam with id ', self.peminjam.id);   
                  self.updatePeminjam();
                  console.log('peminjam updated with id ', self.peminjam.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.peminjams.length; i++){
                  if(self.peminjams[i].id === id) {
                     self.peminjam = angular.copy(self.peminjams[i]);
                     break;
                  }
              }
			  $scope.isEdit = true;
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.peminjam.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deletePeminjam(id);
          };

          
          self.reset = function(){
              self.peminjam= new Peminjam();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
