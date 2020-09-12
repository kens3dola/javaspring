<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="body">

	<div align="center">
		<h1 class="header">Enter new mark</h1>
		<p>${student.studentID}-${student.firstName} ${student.lastName}-${student.gender}-${student.address}</p>
		<p>${course.courseID}-${course.courseName}</p>
		<form:form class="form" action="/spring-mvc/${enrolment.enrolmentID}/mark"
			method="post" modelAttribute="enrolment">
			<div class="formcol hidden">
				<form:input path="enrolmentID"/>
			</div>
			<div class="formcol hidden">
				<form:input path="studentID" />
			</div>
			<div class="formcol hidden">
				<form:input path="courseID" />
			</div>
			<div class="formcol">
				<form:label path="gradeCode">Mark:</form:label>
				<form:select path="gradeCode">
					<form:option value="P">Past</form:option>
					<form:option value="F">Fail</form:option>
				</form:select>
			</div>
			<input class="submit" type="submit" value="Save">
		</form:form>
	</div>
</div>