<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- form -->
<div align="center">
	<h1>Update</h1>
	<form:form action="/spring-mvc/admin/course/updateSubmit" method="post" modelAttribute="course">
		<table>
			<tr>
				<td>Course ID:</td>
				<td><form:input path="courseID" required="true" value="${courseO.courseID}"/></td>
			</tr>
			<tr>
				<td>Course name:</td>
				<td><form:input path="courseName" required="true"  value="${courseO.courseName}"/></td>
			</tr>
			<tr>
				<td>Teacher ID:</td>
				<td><form:input path="teacherID" required="true" type="number" min="1" value="${courseO.teacherID}"/></td>
			</tr>
			<tr>
				<td>Max student:</td>
				<td><form:input path="maxStudent" required="true" type="number" min="1" value="${courseO.maxStudent}"/></td>
			</tr>
			<tr>
				<td>Start:</td>
				<td><form:input path="start" required="true" type="date" value="${courseO.start}"/></td>
			</tr>
			<tr>
				<td>End:</td>
				<td><form:input path="end" required="true" type="date" value="${courseO.end}"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" class="submit"
					value="Save"></td>
			</tr>
		</table>
	</form:form>
</div>