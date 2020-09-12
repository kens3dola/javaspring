<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${noTeacher == null}">
		<h1 class="header">Teachers</h1>
		<table class="table" border="1">
			<tr align="center">
				<th>Teacher ID</th>
				<th>Name</th>
				<th>Gender</th>
				<th>User Name</th>
				<th>*</th>
			</tr>
			<c:forEach var="teacher" items="${teacherList}" varStatus="status">
				<tr align="center">
					<td width="200">${teacher.teacherID}</td>
					<td width="200">${teacher.teacherName}</td>
					<td width="200">${teacher.gender}</td>
					<td width="200">${teacher.userName}</td>
					<td><a
						href="/spring-mvc/admin/users/delete/${teacher.userName}"><i
							class="fas fa-user-slash"></i> Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p align="center">${noTeacher}</p>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${noStudent == null}">
		<h1 class="header">Students</h1>
		<table class="table">
			<tr align="center">
				<th>Student ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Address</th>
				<th>Gender</th>
				<th>Account name</th>
				<th>*</th>
			</tr>
			<c:forEach var="student" items="${studentList}" varStatus="status">
				<tr align="center">
					<td width="200">${student.studentID}</td>
					<td width="200">${student.firstName}</td>
					<td width="200">${student.lastName}</td>
					<td width="200">${student.address}</td>
					<td width="200">${student.gender}</td>
					<td width="200">${student.userName}</td>
					<td><a
						href="/spring-mvc/admin/users/delete/${student.userName}"><i
							class="fas fa-user-slash"></i> Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p align="center">${noStudent}</p>
	</c:otherwise>
</c:choose>