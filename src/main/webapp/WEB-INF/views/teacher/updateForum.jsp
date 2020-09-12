<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<h1>Update information</h1>
	<form:form class="form"
		action="/spring-mvc/forum/${forumO.forumID}/update" method="post"
		modelAttribute="forum">
		<div class="formcol">
			<form:label path="title">Name:</form:label>
			<form:input path="title" required="true" value="${forumO.title}" />
		</div>
		<div class="formcol hidden">
			<form:label path="courseID">Course ID:</form:label>
			<form:input path="courseID" value="${forumO.courseID}" />
		</div>
		<div class="formcol">
			<form:label path="content">Content:</form:label>
			<form:input path="content" required="true" value="${forumO.content}" />
		</div>
		<input id="submit" type="submit" value="Save">
	</form:form>
</div>