<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Icon Cards-->
<div class="body">
	<h1 class="header">Courses</h1>
	<c:forEach var="course" items="${courses}" varStatus="status">
		<table>
			<tr class="cardd body">
				<td class="flex1">${course.courseID}</td>
				<td class="flex2">${course.courseName}</td>
				<td class="flex3"><a
					href="/spring-mvc/${userrole}/coursetoenroll/${course.courseID}"><i
						class="far fa-eye"></i> View</a></td>
			</tr>
		</table>
		<br>
	</c:forEach>
</div>