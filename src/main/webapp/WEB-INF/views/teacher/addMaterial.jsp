<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="body">

	<div align="center">
		<h1 class="header">Create a new material</h1>
		<form:form class="form" action="/spring-mvc/material/add"
			method="post" modelAttribute="material" enctype="multipart/form-data">
			<div class="formcol">
				<form:label path="content">Name:
			</form:label>
				<form:input path="content" required="true" id="content" />
			</div>
			<div class="formcol hidden">
				<form:label path="courseID">Course ID:</form:label>
				<form:input path="courseID" />
			</div>
			<div class="formcol">
				<form:label path="link">Link:</form:label>
				<form:input path="link" />
			</div>
			<input class="submit" type="submit" value="Save">
		</form:form>
	</div>
</div>