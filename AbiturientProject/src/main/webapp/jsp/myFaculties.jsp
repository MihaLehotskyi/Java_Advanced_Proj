<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create faculty</title>
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

		<div style="margin-left: 16% ; margin-top: 3%">
			<div class="w3-container">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th><spring:message code='myfaculty.name'/></th>
							<th><spring:message code='myfaculty.maximumplaces'/></th>
							<th><spring:message code='myfaculty.minimalpoint'/></th>
							<th><spring:message code='myfaculty.image'/></th>
							<th><spring:message code='myfaculty.date'/></th>
							<th><spring:message code='myfaculty.action'/></th>
						</tr>
					</thead>
					<tbody>
						<c:set var = "a" scope = "session" value = "${pageContext.request.userPrincipal.name}"/>
						<c:forEach var="myFaculties" items="${myFacultiesItems}">
						 	<c:if test = "${a == myFaculties.abiturient.email}">
							<tr>
								<td>${myFaculties.id}</td>
								<td>${myFaculties.faculty.name}</td>
								<td>${myFaculties.faculty.maximumplaces}</td>
								<td>${myFaculties.faculty.minimalpoint}</td>
								<td><img
									src="data:image/jpg;base64,${myFaculties.faculty.encodedImage}"
									alt="image" style="width: 10%"></td>
								<td>${myFaculties.enteranceDate}</td>
								<td><a href="myFacultie?id= ${myFaculties.id}"><spring:message code='myfaculty.delete'/></a></td>
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>



			</div>

		</div>
	</div>
</body>
</html>