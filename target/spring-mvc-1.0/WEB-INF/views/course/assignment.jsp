<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="body">
	<a href="/spring-mvc/${role}/course/${assignment.courseID}">Back to
		course</a>
	<div align="center">
		<h1>${assignment.assignmentID}${assignment.title}</h1>
		<p>Start: ${assignment.start}</p>
		<p>End: ${assignment.end}</p>

		<p>
			File:
			<c:set value="${file}" var="file"></c:set>
			<c:choose>
				<c:when test="${file==null}">
					<a href="/spring-mvc/upload/${assignment.assignmentID}">Add new
						file</a>
				</c:when>
				<c:otherwise>
					<span><a
							href="/spring-mvc/assignment/${assignment.assignmentID}/file/${file.fileID}/download"><i
							class="far fa-file"></i>${file.title}.zip</a></span>
					<p>
						<a
							href="/spring-mvc/assignment/${assignment.assignmentID}/file/${file.fileID}/delete">Delete</a>
					</p>
				</c:otherwise>
			</c:choose>
		</p>
		<p align="center" style="color: green">${msg}</p>
	</div>
</div>