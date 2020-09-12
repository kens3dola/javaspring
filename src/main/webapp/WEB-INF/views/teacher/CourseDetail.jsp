<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="body">
	<h1 class="header">${course.courseID}-${course.courseName}</h1>
	<p id="view">
		<a href="/spring-mvc/${course.courseID}/students/"><i
			class="far fa-eye"></i> View all Student</a>
	</p>
	<!--______________________________________________________MATERIAL_____________________________________________________________-->
	<div class="material">
		<h2>Materials</h2>
		<p align="center" style="color: green">${mmsg}</p>
		<c:forEach var="material" items="${materials}">
			<div align="center" class="r">
				<div class="title">${material.materialID}-${material.content}</div>
				<div class="button">
					<a href="/spring-mvc/material/${material.materialID}"><i
						class="far fa-eye"></i>View Details </a> <a
						href="/spring-mvc/material/${material.materialID}/delete"><i
						class="fas fa-trash-alt"></i> Delete</a>
				</div>
			</div>
		</c:forEach>
		<div align="center">
			<a href="/spring-mvc/${course.courseID}/material/add"><i
				class="far fa-plus-square"></i> Add</a>
		</div>
	</div>
	<!-- _________________________________________ASSIGNMENT___________________________________________________ -->

	<div class="material">
		<h2>Assignments</h2>
		<p align="center" style="color: green">${amsg}</p>
		<c:forEach var="assignment" items="${assignments}">
			<div align="center" class="r">
				<div class="title">${assignment.assignmentID}-${assignment.title}</div>
				<div class="button">
					<a href="/spring-mvc/TEACHER/assignment/${assignment.assignmentID}"><i
						class="far fa-eye"></i>View Details </a> <a
						href="/spring-mvc/assignment/${assignment.assignmentID}/update"><i
						class="fas fa-pen"></i> Update</a> <a
						href="/spring-mvc/assignment/${assignment.assignmentID}/delete"><i
						class="fas fa-trash-alt"></i> Delete</a>
				</div>
			</div>
		</c:forEach>
		<div align="center">
			<a href="/spring-mvc/${course.courseID}/assignment/add"><i
				class="far fa-plus-square"></i> Add</a>
		</div>
	</div>
	<!-- _______________________________________________________________FORUM_______________________________________________________ -->
	<div class="material">
		<h2>Forums</h2>
		<p align="center" style="color: green">${fmsg}</p>
		<c:forEach var="forum" items="${forums}">
			<div align="center" class="r">
				<div class="title">${forum.forumID}-${forum.title}</div>
				<div class="button">
					<a href="/spring-mvc/forum/${forum.forumID}"><i
						class="far fa-eye"></i>View Details </a> <a
						href="/spring-mvc/forum/${forum.forumID}/update"><i
						class="fas fa-pen"></i> Update</a> <a
						href="/spring-mvc/forum/${forum.forumID}/delete"><i
						class="fas fa-trash-alt"></i> Delete</a>
				</div>
			</div>
		</c:forEach>
		<div align="center">
			<a href="/spring-mvc/${course.courseID}/forum/add"><i
				class="far fa-plus-square"></i> Add</a>
		</div>
	</div>
</div>