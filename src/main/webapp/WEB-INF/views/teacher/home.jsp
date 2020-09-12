<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- Icon Cards-->
<div class="body">

	<section align="center" class="">
		<h1 class="header">Announcements</h1>
		<div class="anno">
			<c:forEach var="notification" items="${notifications}"
				varStatus="status">
				<div class="bl body">
					<h2><i class="far fa-bell"></i> ${notification.title}</h2>
					<p>
						<span>${notification.date}</span> TeacherID: <span><i>${notification.teacherID}</i></span>
					</p>
					<hr>
					<p>${notification.content}</p><a
						href="/spring-mvc/notification/${notification.notificationID}/delete"><i
						class="fas fa-trash-alt"></i> Delete</a>
				</div>
			</c:forEach>
			<div align="center">
			<a href="/spring-mvc/notification/add"><i
				class="far fa-plus-square"></i> Add</a>
		</div>
		</div>

	</section>
	<h1 class="header">Courses</h1>
	<c:forEach var="course" items="${courses}">
		<table>
			<tr class="cardd body">
				<td class="flex1">${course.courseID}</td>
				<td class="flex2">${course.courseName}</td>
				<td class="flex3"><a
					href="/spring-mvc/${userrole}/course/${course.courseID}"><i
						class="far fa-eye"></i> View</a></td>
			</tr>
		</table>
		<br>
	</c:forEach>
</div>