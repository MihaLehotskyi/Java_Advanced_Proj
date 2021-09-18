<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        
        <spring:bind path="Firstname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="Firstname" class="form-control" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="Firstname"></form:errors>
            </div>
        </spring:bind>
        
          <spring:bind path="Secondname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="Secondname" class="form-control" placeholder="Second name"
                            autofocus="true"></form:input>
                <form:errors path="Secondname"></form:errors>
            </div>
        </spring:bind>
        
        
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email" class="form-control" placeholder="Email"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="dateOfBirth">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="date" path="dateOfBirth" class="form-control" placeholder="Date of birth"
                            autofocus="true"></form:input>
                <form:errors path="dateOfBirth"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="firstsubject">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstsubject" class="form-control"
                            placeholder="First subject"></form:input>
                <form:errors path="firstsubject"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="firstsubjectpoint">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="firstsubjectpoint" class="form-control"
                            placeholder="First subject point"></form:input>
                <form:errors path="firstsubjectpoint"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="secondsubject">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="secondsubject" class="form-control"
                            placeholder="Second subject"></form:input>
                <form:errors path="secondsubject"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="secondsubjectpoint">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="secondsubjectpoint" class="form-control"
                            placeholder="Second subject point"></form:input>
                <form:errors path="secondsubjectpoint"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="thirdsubject">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="thirdsubject" class="form-control"
                            placeholder="Third subject"></form:input>
                <form:errors path="thirdsubject"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="thirdsubjectpoint">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="thirdsubjectpoint" class="form-control"
                            placeholder="Third subject point"></form:input>
                <form:errors path="thirdsubjectpoint"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>