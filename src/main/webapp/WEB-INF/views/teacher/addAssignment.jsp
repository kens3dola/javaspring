<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<h1>Create a new Assignment</h1>
	<form:form class="form" action="/spring-mvc/assignment/add"
		method="post" modelAttribute="assignment">
			<div class="formcol">
				<form:label path="title">Name:</form:label>
				<form:input path="title" required="true" />
			</div>
			<div class="formcol hidden">
				<form:label path="courseID">Course ID:</form:label>
				<form:input path="courseID" />
			</div>
			<div class="formcol">
				<form:label path="start">Start in:</form:label>
				<form:input path="start" type="date" required="true"/>
			</div>
			<div class="formcol">
				<form:label path="end">End in:</form:label>
				<form:input path="end" type="date" required="true"/>
			</div>
			<input class="submit" type="submit" value="Save">
	</form:form>
</div>
