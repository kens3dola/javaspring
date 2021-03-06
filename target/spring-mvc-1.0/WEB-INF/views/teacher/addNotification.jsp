<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
	<h1>Create a new notification</h1>
	<form:form class="form" action="/spring-mvc/notification/add" method="post"
		modelAttribute="notification">
		<div class="formcol">
			<form:label path="title">Name:</form:label>
			<form:input path="title" required="true"/>
		</div>
		<div class="formcol hidden">
			<form:input path="teacherID" value="${teacherID}" />
		</div>
		<div class="formcol">
			<form:label path="content">Description:</form:label>
			<form:input path="content" required="true" />
		</div>
		<input class="submit" type="submit" value="Save">
	</form:form>
</div>