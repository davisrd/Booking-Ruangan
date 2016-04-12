<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="employee">
		<table>
			<tr>
				<td><label for="nip">NIP: </label> </td>
				<td><form:input path="nip" id="nip"/></td>
				<td><form:errors path="nip" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="nama">Nama: </label> </td>
				<td><form:input path="nama" id="nama"/></td>
				<td><form:errors path="nama" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="jurusan">Jurusan: </label> </td>
				<td><form:input path="jurusan" id="jurusan"/></td>
				<td><form:errors path="jurusan" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="tgl_pinjam">Tanggal Pinjam: </label> </td>
				<td><form:input path="tgl_pinjam" id="tgl_pinjam"/></td>
				<td><form:errors path="tgl_pinjam" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="kegiatan">Kegiatan: </label> </td>
				<td><form:input path="kegiatan" id="kegiatan"/></td>
				<td><form:errors path="kegiatan" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td><label for="ruangan">Ruangan: </label> </td>
				<td><form:input path="ruangan" id="ruangan"/></td>
				<td><form:errors path="ruangan" cssClass="error"/></td>
		    </tr>
		    
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>