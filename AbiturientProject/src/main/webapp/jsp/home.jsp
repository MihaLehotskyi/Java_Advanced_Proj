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

<title><spring:message code='login.title'/></title>

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
<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>
</head>

<body>
	<div class="container-fluid">

		<div class="w3-sidebar" style="width: 15%">

			<div class="list-group" style="margin-top: 40px">

				<div class="list-group-item active">
					<div>
						<h3><spring:message code='login.title'/></h3>
					</div>
					<div>${pageContext.request.userPrincipal.name}</div>
				</div>

				<a href="/home" class="list-group-item"> <i
					class="fa fa-comment-o"></i> <spring:message code='sidebar.home'/>
				</a>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="/create-faculty" class="list-group-item"> <i
						class="fa fa-search"></i> <spring:message code='sidebar.create_faculty'/>
					</a>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ABITURIENT')">
					<a href="/myFaculties" class="list-group-item"> <i
						class="fa fa-search"></i> <spring:message code='sidebar.myfaculties'/>
					</a>
				</security:authorize>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<a class="list-group-item"
						onclick="document.forms['logoutForm'].submit()"
						style="cursor: pointer"> <i class="fa fa-search"></i> <spring:message code='sidebar.logout'/>
					</a>
				</c:if>
			</div>

		</div>
			
	<div style="margin-left: 16%">
			<div class="w3-container">
			
				<c:if test="${not empty faculty}">
					<c:forEach items="${faculty}" var="currentFaculty">

						<div class="w3-card-4" style="width: 29%; margin: 2%; float:left">
							<header class="w3-container w3-light-grey">
								<h3><spring:message code='faculty.name1'/> ${currentFaculty.name}</h3>
							</header>
							<div class="w3-container">
								<hr>
								<img src="data:image/jpg;base64,${currentFaculty.encodedImage}"
									alt="Avatar" class="w3-left w3-circle w3-margin-right"
									style="width: 60px">
								<p><spring:message code='faculty.maximumplaces1'/>${currentFaculty.maximumplaces}</p>
								<p><spring:message code='faculty.minimalpoint1'/>${currentFaculty.minimalpoint}</p>
								<br>
							</div>
							<security:authorize access="hasRole('ROLE_ABITURIENT')">
								<form:form action="${contextPath}/myFacultie" method="POST"
									enctype="multipart/form-data">
									<input type="hidden" value="${currentFaculty.id}"
										class="form-control" name="facultyId">
									<input type="submit" class="w3-button w3-block w3-dark-grey"
										value="+ <spring:message code='myfaculty.add'/>">
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