<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- form -->
<div align="center">
	<p align="center" style="color: red">${msg}</p>
	<h1 class="header">Create new course</h1>
	<form:form action="createCourse" method="post" modelAttribute="course">
		<div class="form">
			<div class="col1">
				<form:label path="courseID">Course ID:</form:label>
				<form:input path="courseID" required="true" placeholder="Course ID" />
				<form:label path="courseName">Course's name:</form:label>
				<form:input path="courseName" required="true" placeholder="Name" />
				<form:label path="teacherID">Teacher ID:</form:label>
				<form:input path="teacherID" required="true" type="number" min="1" />
			</div>
			<div class="col1">
				<form:label path="maxStudent">Max student:</form:label>
				<form:input path="maxStudent" required="true" type="number" min="1"/>
				<form:label path="start">Start in:</form:label>
				<form:input path="start" required="true" type="date" />
				<form:label path="end">End in:</form:label>
				<form:input path="end" required="true" type="date" />
			</div>
		</div>
		<input type="submit" value="Save" class="button">
	</form:form>
</div>
<br>
<hr>
<br>
<!-- list -->
<h1 class="header">Courses</h1>
<c:choose>
	<c:when test="${noCourse == null}">
		<table class="table">
			<tr align="center">
				<th>Course ID</th>
				<th>Name</th>
				<th>Teacher ID</th>
				<th>Max Student</th>
				<th>Start</th>
				<th>End</th>
				<th>*</th>
			</tr>
			<c:forEach var="course" items="${courseList}" varStatus="status">
				<tr align="center">
					<td width="200">${course.courseID}</td>
					<td width="200">${course.courseName}</td>
					<td width="200">${course.teacherID}</td>
					<td width="200">${course.maxStudent}</td>
					<td width="200">${course.start}</td>
					<td width="200">${course.end}</td>
					<td><p>
							<a href="/spring-mvc/admin/course/update/${course.courseID}"><i
								class="fas fa-pen"></i> Update</a> <a
								href="/spring-mvc/admin/course/delete/${course.courseID}"><i
								class="fas fa-trash-alt"></i> Delete</a>
						</p></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p align="center">${noCourse}</p>
	</c:otherwise>
</c:choose>