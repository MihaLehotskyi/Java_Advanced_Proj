<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create faculty</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
		<div class="w3-sidebar w3-bar-block" style="width: 10%">
			<a href="/home" class="w3-bar-item w3-button">Home</a>
			
			<security:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/create-faculty" class="w3-bar-item w3-button">Create faculty</a>  
			</security:authorize>
			
			<security:authorize access="hasRole('ROLE_ABITURIENT')">
			<a href="/myFaculties" class="w3-bar-item w3-button">My faculties</a>
			</security:authorize>
		</div>

		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1>Create new Faculty</h1>
			</div>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<h2>
					Welcome ${pageContext.request.userPrincipal.name} | <a
						onclick="document.forms['logoutForm'].submit()">Logout</a>
				</h2>

			</c:if>


			<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Maximum places</th>
							<th>Minimal point</th>
							<th>Image</th>
							<th>Entry Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myFaculties" items="${myFacultiesItems}">
							<tr>
								<td>${myFaculties.id}</td>
								<td>${myFaculties.faculty.name}</td>
								<td>${myFaculties.faculty.maximumplaces}</td>
								<td>${myFaculties.faculty.minimalpoint}</td>
								<td><img src="data:image/jpg;base64,${myFaculties.faculty.encodedImage}" alt="image" style="width: 10%"></td>
								<td>${myFaculties.enteranceDate}</td>
								<td><a href="myFacultie?id= ${myFaculties.id}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



		</div>

	</div>
</body>
</html>