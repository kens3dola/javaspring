<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="body">
	<h1 class="header">${course.courseID}-${course.courseName}</h1>
	<div class="body">
		<!--______________________________________________________MATERIAL_____________________________________________________________-->
		<h2>Materials</h2>
		<p align="center" style="color: green">${mmsg}</p>
		<c:forEach var="material" items="${materials}">
			<div align="center" class="r">
				<div class="title">${material.materialID}-${material.content}</div>
				<div class="button">
					<a href="/spring-mvc/material/${material.materialID}"><i
						class="far fa-eye"></i>View Details </a>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- _________________________________________ASSIGNMENT___________________________________________________ -->
	<div class="body">
		<h2>Assignments</h2>
		<p align="center" style="color: green">${amsg}</p>
		<c:forEach var="assignment" items="${assignments}">
			<div align="center" class="r">
				<div class="title">${assignment.assignmentID}-${assignment.title}</div>
				<div class="button">
					<a href="/spring-mvc/assignment/${assignment.assignmentID}"><i
						class="far fa-eye"></i>View Details </a>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- _______________________________________________________________FORUM_______________________________________________________ -->
	<div class="body">
		<h2>Forums</h2>
		<p align="center" style="color: green">${fmsg}</p>
		<c:forEach var="forum" items="${forums}">
			<div align="center" class="r">
				<div class="title">${forum.forumID}-${forum.title}</div>
				<div class="button">
					<a href="/spring-mvc/forum/${forum.forumID}"><i
						class="far fa-eye"></i>View Details </a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>