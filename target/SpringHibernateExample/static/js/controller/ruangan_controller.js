'use strict';

App.controller('RuanganController', ['$scope', 'Ruangan', function($scope, Ruangan) {
		$scope.Manggil = function(){
			alert(self.ruangan);
			console.log(self.ruangans);
		};
          $scope.isEdit = false;
		  var self = this;
          self.ruangan= new Ruangan();
          
          self.ruangans=[];
              
          self.fetchAllRuangans = function(){
        	  self.ruangans = Ruangan.query();
          };
           
          self.createRuangan = function(){
        	  self.ruangan.$save(function(){
        		  self.fetchAllRuangans();
        	  });
          };

          self.updateRuangan = function(){
        	  self.ruangan.$update(function(){
    			  self.fetchAllRuangans();
    		  });
          };

         self.deleteRuangan = function(identity){
        	 var ruangan = Ruangan.get({id:identity}, function() {
        		  ruangan.$delete(function(){
        			  console.log('Deleting ruangan with id ', identity);
        			  self.fetchAllRuangans();
        		  });
        	 });
          };

          self.fetchAllRuangans();

          self.submit = function() {
              if($scope.isEdit==false){
                  console.log('Saving New Ruangan', self.ruangan);    
                  self.createRuangan();
              }else{
    			  console.log('Updating ruangan with id ', self.ruangan.id);   
                  self.updateRuangan();
                  console.log('Ruangan updated with id ', self.ruangan.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.ruangans.length; i++){
                  if(self.ruangans[i].id === id) {
                     self.ruangan = angular.copy(self.ruangans[i]);
                     break;
                  }
              }
			  $scope.isEdit = true;
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.ruangan.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteRuangan(id);
          };

          
          self.reset = function(){
              self.ruangan= new Ruangan();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
