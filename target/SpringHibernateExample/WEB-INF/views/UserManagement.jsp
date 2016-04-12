<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS ngResource Example</title>  
    <style>
      .select {
          background-color: lightgreen;
      }
      .select.ng-dirty.ng-invalid-required {
          background-color: red;
      }

      .input.ng-valid {
          background-color: lightgreen;
      }
      .input.ng-dirty.ng-invalid-required {
          background-color: red;
      }

    </style>
     <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">-->
	 <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />"></link>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="PeminjamanController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Peminjam Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="isEdit" />
					  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="peminjam">Peminjam</label>
                              <div class="col-md-7">
								<select ng-class="ctrl.selected()" class="form-control input-sm" name="peminjamSelect" id="peminjamSelect" ng-model="ctrl.peminjaman.peminjam">
								  <option value="">---Please select---</option>
								  <option ng-repeat="peminjam in ctrl.peminjams" value="{{peminjam}}">{{peminjam.nama}}</option>
								</select>
								<div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.peminjam.$error.required">This is a required field</span>
                                      <span ng-show="myForm.peminjam.$invalid">This field is invalid </span>
                                  </div>
							  </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="jurusan">Jurusan</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.peminjaman.jurusan" id="jurusan" class="input form-control input-sm" placeholder="Enter your Jurusan" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.jurusan.$error.required">This is a required field</span>
                                      <span ng-show="myForm.jurusan.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
					  
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="tgl_pinjam">Tanggal Pinjam</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.peminjaman.tgl_pinjam" id="tgl_pinjam" class="input form-control input-sm" placeholder="Enter booking date" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.tgl_pinjam.$error.required">This is a required field</span>
                                      <span ng-show="myForm.tgl_pinjam.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
					  
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="kegiatan">Kegiatan</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.peminjaman.kegiatan" id="kegiatan" class="input form-control input-sm" placeholder="Enter your Kegiatan" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.kegiatan.$error.required">This is a required field</span>
                                      <span ng-show="myForm.kegiatan.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

					  
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="ruangan">Ruangan</label>
                              <div class="col-md-7">
                                <select class="form-control input-sm" name="ruanganSelect" id="ruanganSelect" ng-model="ctrl.peminjaman.ruangan">
								  <option value="">---Please select---</option>
								  <option ng-repeat="ruangan in ctrl.ruangans" value="{{ruangan}}">{{ruangan.namaRuangan}}</option>
								</select>
								<div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.ruangan.$error.required">This is a required field</span>
                                      <span ng-show="myForm.ruangan.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
					  
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!isEdit ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
						  </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-actions floatRight">
							  <a href="<c:url value='/PeminjamManagement' />"><button type="button" class="btn btn-warning btn-sm" >Add Peminjam</button></a>
						  	  <a href="<c:url value='/RuanganManagement' />"><button type="button" class="btn btn-warning btn-sm" >Add Ruangan</button></a>
						  </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Peminjamans </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID Peminjaman</th>
                              <th>Nama Peminjam</th>
							  <th>Nama Ruangan</th>
                              <th>Jurusan</th>
                              <th>Tanggal Pinjam</th>
                              <th>Kegiatan</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.peminjamans">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.peminjam.nama"></span></td>
                              <td><span ng-bind="u.ruangan.namaRuangan"></span></td>
                              <td><span ng-bind="u.jurusan"></span></td>
							  <td><span ng-bind="u.tgl_pinjam"></span></td>
                              <td><span ng-bind="u.kegiatan"></span></td>
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
      <script src="<c:url value='/static/js/service/peminjaman_service.js' />"></script>
      <script src="<c:url value='/static/js/service/ruangan_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/peminjam_controller.js' />"></script>
      <script src="<c:url value='/static/js/controller/peminjaman_controller.js' />"></script>
      <script src="<c:url value='/static/js/controller/ruangan_controller.js' />"></script>
  </body>
</html>