<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Icon Cards-->
<c:forEach var="course" items="${courses}">
<div class="row">
	<div class="col-xl-3 col-sm-6 mb-3">
		<div class="card text-white o-hidden bg-primary h-100">
			<div class="card-body">
				<div class="mr-5">${course.courseID}</div>
			</div>
			<a class="card-footer text-white clearfix small z-1" href="/spring-mvc/${userrole}/coursetoenroll/${course.courseID}"> <span
				class="float-left">View Details</span> <span class="float-right">
					<i class="fas fa-angle-right"></i>
			</span>
			</a>
		</div>
	</div>
</div>
</c:forEach>