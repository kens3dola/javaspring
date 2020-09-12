<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="body">
	<div align="center">
		<h1>${assignment.assignmentID}-${assignment.title}</h1>
		<p>Start: ${assignment.start}</p>
		<p>End: ${assignment.end}</p>
	</div>
	<a href="/spring-mvc/${role}/course/${courseID}">Back to course</a>
	<div align="center" class="body">
		<h1 class="header">Submitted files</h1>
		<c:set value="${files}" var="a"></c:set>
		<c:choose>
			<c:when test="${a == null}"> 
				<p align="center">No file</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="file" items="${files}">
					<div class="body">
						<h1>Name: ${file.title}</h1>
						<p>Student: ${file.userName}</p>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>