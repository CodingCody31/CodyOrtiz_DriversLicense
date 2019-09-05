<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Person Page</title>
</head>
<body>
	<h1>New Person</h1>
	<div>
	<form:form action="/persons/new" method = "post" modelAttribute="person">
		<label for="firstName">First Name</label>
		<form:input path="firstName" placeholder="First Name"/>
		<label for="lastName">Last Name</label>
		<form:input path="lastName" placeholder="Last Name"/>
		<input type="Submit" value="Submit"/>
	</form:form>
	</div>
		
</body>
</html>