<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center" class="register">
	<h1 class="header">Create a new Account</h1>
	<p align="center" style="color: red">${msg}</p>
	<form:form class="register" action="register" method="post" modelAttribute="account">
		<form:label path="userName">User name</form:label>
		<form:input path="userName" require="true" id="userName" />
		<form:label path="passWord">Password</form:label>
		<form:input path="passWord" require="true" />
		<form:label path="userRole">Role</form:label>
		<form:select path="userRole">
			<form:option value="STUDENT">Student</form:option>
			<form:option value="TEACHER">Teacher</form:option>
		</form:select>
		<input class="button" type="submit" value="Save">
	</form:form>
</div>