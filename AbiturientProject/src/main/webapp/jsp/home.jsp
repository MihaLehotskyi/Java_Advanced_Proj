<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
		<div class="w3-sidebar w3-bar-block" style="width: 10%">
			<a href="/create-faculty" class="w3-bar-item w3-button">Create
				faculty</a> <a href="/home" class="w3-bar-item w3-button">Home</a> <a
				href="#" class="w3-bar-item w3-button">My faculties</a>
		</div>

		<div style="margin-left: 10%">
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

			<c:if test="${not empty faculty}">
				<c:forEach items="${faculty}" var="currentFaculty">

					<div class="w3-card-4" style="width: 25%">
						<header class="w3-container w3-light-grey">
							<h3>${currentFaculty.name}</h3>
						</header>
						<div class="w3-container">
							<hr>
							<img
								src="data:image/jpg;base64,${currentFaculty.encodedImage}"
								alt="Avatar" class="w3-left w3-circle w3-margin-right"
								style="width: 60px">
							<p>${currentFaculty.maximumplaces}</p>
							<p>${currentFaculty.minimalpoint}</p>
							<br>
						</div>
						<button class="w3-button w3-block w3-dark-grey">Submit documents to the university</button>
					</div>
				</c:forEach>
			</c:if>
		</div>

	</div>

	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>