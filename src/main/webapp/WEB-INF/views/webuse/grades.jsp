<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- DataTables Example -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Grades
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable">
				<thead>
					<tr>
						<th>CourseID</th>
						<th>Grade</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="en" items="${enrolment}"></c:forEach>
					<tr>
						<td>${en.courseID}</td>
						<td>${en.gradeCode}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>