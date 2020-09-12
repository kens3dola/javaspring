<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- News list -->

<section id="about">
	<h1 class="announce">Announcements</h1>
	<c:choose>
		<c:when test="${noNotification == null}">
			<div>
				<div class="anno">
					<c:forEach var="notification" items="${listNotification}"
						varStatus="status">
						<div class="bl">
							<h2>&#9993; ${notification.title}</h2>
							<p>
								<span>${notification.date}</span> TeacherID: <span><i>${notification.teacherID}</i></span>
							</p>
							<hr>
							<p>${notification.content}</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<p align="center">${noNotification}</p>
		</c:otherwise>
	</c:choose>

</section>
<!-- Teachers list -->

<section id="services" class="bg-light">
	<h1 class="announce">Teachers</h1>
	<c:choose>
		<c:when test="${noTeacher==null}">
			<table class="table">
				<tr>
					<th>Teacher ID</th>
					<th>Name</th>
					<th>Gender</th>
				</tr>
				<c:forEach var="teacher" items="${listTeacher}" varStatus="status">
					<tr>
						<td width="200">${teacher.teacherID}</td>
						<td width="200">${teacher.teacherName}</td>
						<td width="200">${teacher.gender}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p align="center">${noTeacher}</p>
		</c:otherwise>
	</c:choose>
</section>