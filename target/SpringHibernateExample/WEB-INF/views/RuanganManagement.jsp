<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS ngResource Example</title>  
    <style>
      .id.ng-valid {
          background-color: lightgreen;
      }
      .id.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .id.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
      .id.ng-dirty.ng-invalid-maxlength {
          background-color: yellow;
      }
      
      .nama.ng-valid {
          background-color: lightgreen;
      }
      .nama.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .nama.ng-dirty.ng-invalid-maxlength {
          background-color: yellow;
      }
      
      .jenis.ng-valid {
          background-color: lightgreen;
      }
      .jenis.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .jenis.ng-dirty.ng-invalid-maxlength {
          background-color: yellow;
      }
      
    </style>
     <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
	 <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />"></link>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="RuanganController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Peminjam Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.ruangan.id" />

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="noRuangan">No Ruangan</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.ruangan.noRuangan" id="noRuangan" class="id form-control input-sm" placeholder="Enter Room No" required ng-minlength="5" ng-maxlength="5"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.noRuangan.$error.required">This is a required field</span>
                                      <span ng-show="myForm.noRuangan.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="namaRuangan">Nama Ruangan</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.ruangan.namaRuangan" id="namaRuangan" class="nama form-control input-sm" placeholder="Enter Room Name" required ng-maxlength="20"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.namaRuangan.$error.required">This is a required field</span>
                                      <span ng-show="myForm.namaRuangan.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="jenisRuangan">Jenis Ruangan</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.ruangan.jenisRuangan" id="jenisRuangan" class="jenis form-control input-sm" placeholder="Enter Room Type" required ng-maxlength="10"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.jenisRuangan.$error.required">This is a required field</span>
                                      <span ng-show="myForm.jenisRuangan.$invalid">This field is invalid </span>
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
                              <th>ID Ruangan</th>
                              <th>No Ruangan</th>
                              <th>Nama Ruangan</th>
                              <th>Jenis Ruangan</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.ruangans">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.noRuangan"></span></td>
                              <td><span ng-bind="u.namaRuangan"></span></td>
                              <td><span ng-bind="u.jenisRuangan"></span></td>
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
      <script src="<c:url value='/static/js/service/ruangan_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/ruangan_controller.js' />"></script>
  </body>
</html>