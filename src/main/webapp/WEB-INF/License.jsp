<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>License Page</title>
</head>
<body>
	<h1>New License</h1>
	<div>
	<c:forEach items="${person}" var="person">
		<select>
		<option><c:out value="${person.firstName}"/></option>
		</select>
	</c:forEach>
	</div>
	<div>
	<form:form action="/licenses/new/${person.id})" method ="post" modelAttribute="license">
		<label for="state">State</label>
		<form:input path="state" placeholder="State"/>
		<label for="expirationDate">Expiration Date</label>
		<form:input path="expirationDate" placeholder="Expiration Date"/>
		<input type="Submit" value="Submit"/>
	</form:form>
	</div>
</body>
</html>