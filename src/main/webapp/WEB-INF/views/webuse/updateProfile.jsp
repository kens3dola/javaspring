<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="body">
	<h1 class="header">Update profile</h1>
	<c:set value="${role }" var="role"></c:set>
	<c:choose>
		<c:when test="${role=='TEACHER'}">
			<form:form id="updatestudentprofile" modelAttribute="teacher"
				action="/spring-mvc/updateprofile" method="post">
				<table class="profile">
					<tr>
						<td><form:label path="teacherID">Teacher ID:</form:label></td>
						<td><form:input path="teacherID" required="true" min="1" type="number"
								value="${teacherO.teacherID}" /></td>
					</tr>
					<tr>
						<td><form:label path="teacherName">Name:</form:label></td>
						<td><form:input path="teacherName" required="true"
								value="${teacherO.teacherName}" /></td>
					</tr>
					<tr>
						<td><form:label path="gender">Gender:</form:label></td>
						<td><form:select path="gender" value="${teacherO.gender}">
								<form:option value="MALE">Male</form:option>
								<form:option value="FEMALE">Female</form:option>
							</form:select></td>
					</tr>
					<tr class="center">
						<td><form:button id="prfile" class="submit" name="update">Update</form:button></td>
					</tr>
				</table>
			</form:form>
		</c:when>
		<c:when test="${role=='STUDENT'}">
			<form:form id="updatestudentprofile" modelAttribute="student"
				action="/spring-mvc/updateprofile" method="post">
				<table>
					<tr>
						<td><form:label path="studentID">Student ID:</form:label></td>
						<td><form:input path="studentID" type="number" required="true" min="1"
								value="${studentO.studentID}" /></td>
					</tr>
					<tr>
						<td><form:label path="firstName">First name:</form:label></td>
						<td><form:input path="firstName" required="true" 
								value="${studentO.firstName}" /></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last name:</form:label></td>
						<td><form:input path="lastName" required="true"  value="${studentO.lastName}" /></td>
					</tr>
					<tr>
						<td><form:label path="gender">Gender:</form:label></td>
						<td><form:select path="gender" value="${studentO.gender}">
								<form:option value="MALE">Male</form:option>
								<form:option value="FEMALE">Female</form:option>
							</form:select></td>
					</tr>
					<tr>
						<td><form:label path="address">Address:</form:label></td>
						<td><form:input path="address" required="true"  value="${studentO.address}" /></td>
					</tr>
					<tr class="center">
						<td><form:button id="prfile" class="submit" name="update">Update</form:button></td>
					</tr>
				</table>
			</form:form>
		</c:when>
	</c:choose>
</div>