<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="body">
<div align="center">
	<a class="nav-link" href="/spring-mvc/${userrole}/viewAllCourse"> <i
		class="fas fa-fw fa-tachometer-alt"></i> <span>Enrol/Unenroll courses</span>
	</a>
	<a class="nav-link" href="/spring-mvc/STUDENT/grades"> <i
		class="fas fa-fw fa-tachometer-alt"></i> <span>Grades</span>
	</a>
</div>
<section align="center" class="">
		<h1 class="header">Announcements</h1>
		<div class="anno">
			<c:forEach var="notification" items="${notifications}"
				varStatus="status">
				<div class="bl">
					<h2><i class="far fa-bell"></i> ${notification.title}</h2>
					<p>
						<span>${notification.date}</span> TeacherID: <span><i>${notification.teacherID}</i></span>
					</p>
					<hr>
					<p>${notification.content}</p>
				</div>
			</c:forEach>
		</div>

	</section>
<!-- Icon Cards-->
	<h1 class="header">Courses</h1>
<c:forEach var="enrolment" items="${enrolments}" varStatus="status">
	<table>
			<tr class="cardd body">
				<td class="flex1">${status.index + 1}</td>
				<td class="flex2">${enrolment.courseID}</td>
				<td class="flex3"><a
					href="/spring-mvc/${userrole}/course/${enrolment.courseID}"><i
						class="far fa-eye"></i> View</a></td>
			</tr>
		</table>
		<br>
</c:forEach>
</div>