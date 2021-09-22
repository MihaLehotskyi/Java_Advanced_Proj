<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create faculty</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container">
	<div class="w3-sidebar w3-bar-block" style="width:10%">
  <a href="/create-faculty" class="w3-bar-item w3-button">Create faculty</a>
  <a href="/home" class="w3-bar-item w3-button">Home</a>
  <a href="#" class="w3-bar-item w3-button">My faculties</a>
</div>

<div style="margin-left:10%">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<div class="w3-container w3-teal">
				<h1>Create new Faculty</h1>
			</div>
        
         
		<form:form method="POST" action="${contextPath}/addFaculty" modelAttribute = "faculty">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="maximumplaces">Maximum places</form:label></td>
				<td><form:input path="maximumplaces"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="minimalpoint">Minimal point</form:label></td>
				<td><form:input path="minimalpoint"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></input></td>
			</tr>
			
		</table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
		</form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>
</div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>