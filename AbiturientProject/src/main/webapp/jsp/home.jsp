<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
</head>

<body>
	<div class="container-fluid">

		<div class="w3-sidebar" style="width: 10%">

			<div class="list-group" style="margin-top: 40px">

				<div class="list-group-item active">
					<div>
						<h3>FACULTIES</h3>
					</div>
					<div>${pageContext.request.userPrincipal.name}</div>
				</div>

				<a href="/home" class="list-group-item"> <i
					class="fa fa-comment-o"></i> Home
				</a>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="/create-faculty" class="list-group-item"> <i
						class="fa fa-search"></i> Create faculty
					</a>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ABITURIENT')">
					<a href="/myFaculties" class="list-group-item"> <i
						class="fa fa-search"></i> My faculties
					</a>
				</security:authorize>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<a class="list-group-item"
						onclick="document.forms['logoutForm'].submit()"
						style="cursor: pointer"> <i class="fa fa-search"></i> Logout
					</a>
				</c:if>
			</div>

		</div>
			
	<div style="margin-left: 10%">
			<div class="w3-container">
			
				<c:if test="${not empty faculty}">
					<c:forEach items="${faculty}" var="currentFaculty">

						<div class="w3-card-4" style="width: 20%; margin: 2%">
							<header class="w3-container w3-light-grey">
								<h3>${currentFaculty.name}</h3>
							</header>
							<div class="w3-container">
								<hr>
								<img src="data:image/jpg;base64,${currentFaculty.encodedImage}"
									alt="Avatar" class="w3-left w3-circle w3-margin-right"
									style="width: 60px">
								<p>${currentFaculty.maximumplaces}</p>
								<p>${currentFaculty.minimalpoint}</p>
								<br>
							</div>
							<security:authorize access="hasRole('ROLE_ABITURIENT')">
								<form:form action="${contextPath}/myFacultie" method="POST"
									enctype="multipart/form-data">
									<input type="hidden" value="${currentFaculty.id}"
										class="form-control" name="facultyId">
									<input type="submit" class="w3-button w3-block w3-dark-grey"
										value="+ add documents">
								</form:form>
							</security:authorize>
						</div>
					</c:forEach>
				</c:if>
			</div>

		</div>
	</div>

		<!-- /container -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>