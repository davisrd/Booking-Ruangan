<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Employees</h2>	
	<table>
		<tr>
			<td>NIP</td><td>Nama Peminjam</td><td>Nama Ruangan</td><td>Jurusan</td><td>Tanggal Pinjam</td><td>Kegiatan</td><td>Ruangan</td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
			<td>${employee.id}</td>
			<td>${employee.peminjam.getNama()}</td>
			<td>${employee.ruangan.getNamaRuangan()}</td>
			<td>${employee.jurusan}</td>
			<td>${employee.tgl_pinjam}</td>
			<td>${employee.kegiatan}</td>
			<td>${employee.ruangan}</td>
			<td><a href="<c:url value='/edit-${employee.nip}-employee' />">edit</a></td>
			<td><a href="<c:url value='/delete-${employee.nip}-employee' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>