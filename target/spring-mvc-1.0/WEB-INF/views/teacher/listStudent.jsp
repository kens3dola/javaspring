<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach var="enrolment" items="${enrolments}" begin="1" end="1">
<a href="/spring-mvc/${role}/course/${enrolment.courseID}">Back to course</a>
</c:forEach>
<!-- DataTables Example -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Students
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable">
				<c:set var="student" value="${students}"></c:set>
				<c:choose>
					<c:when test="${student==null}">
						<p>No student found</p>
					</c:when>
					<c:otherwise>
						<thead>
							<tr>
								<th>Student ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Gender</th>
								<th>Address</th>
								<th>Mark</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${students}" varStatus="loop">
								<tr>
									<td>${student.studentID}</td>
									<td>${student.firstName }</td>
									<td>${student.lastName }</td>
									<td>${student.gender }</td>
									<td>${student.address }</td>
									<c:forEach var="enrolment" items="${enrolments}" begin="${loop.index}" end="${loop.index}">
									<td>${enrolment.gradeCode} <a href="/spring-mvc/${enrolment.enrolmentID}/mark">Update mark</a></td>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</c:otherwise>
				</c:choose>

			</table>
		</div>
	</div>
	<div class="card-footer small text-muted">_______________________</div>
</div>