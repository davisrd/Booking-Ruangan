<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS ngResource Example</title>  
    <style>
      .nip.ng-valid {
          background-color: lightgreen;
      }
      .nip.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .nip.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
      .nip.ng-dirty.ng-invalid-maxlength {
          background-color: yellow;
      }
      
      .nama.ng-valid {
          background-color: lightgreen;
      }
      .nama.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .nama.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
      
    </style>
     <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
	 <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />"></link>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="PeminjamController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Peminjam Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.peminjam.id" />

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="nipPeminjam">NIP</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.peminjam.nip" id="nipPeminjam" class="nip form-control input-sm" placeholder="Enter your NIP" required ng-minlength="9" ng-maxlength="9"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.nipPeminjam.$error.required">This is a required field</span>
                                      <span ng-show="myForm.nipPeminjam.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="namaPeminjam">Nama</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.peminjam.nama" id="namaPeminjam" class="nama form-control input-sm" placeholder="Enter your Name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.namaPeminjam.$error.required">This is a required field</span>
                                      <span ng-show="myForm.namaPeminjam.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
					  
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!isEdit ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
							  <a href="<c:url value='/' />"><button type="button" class="btn btn-warning btn-sm" >Back</button></a>
						  </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Peminjams </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>NIP</th>
                              <th>Nama Peminjam</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.peminjams">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.nip"></span></td>
                              <td><span ng-bind="u.nama"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script> -->
      <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script> -->
	  <script src="<c:url value='/static/js/angular/angular.js' />"></script>
	  <script src="<c:url value='/static/js/angular/angular-resource.js' />"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/peminjam_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/peminjam_controller.js' />"></script>
  </body>
</html>