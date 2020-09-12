<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="body">


	<a href="/spring-mvc/${role}/course/${material.courseID}"><i class="fas fa-angle-left"></i> Back to
		course</a>
	<div align="center">
		<h1>${material.materialID}- ${material.content}</h1>
		<p>Course: ${material.courseID}</p>
		<p>
			Link: <a href="${material.link}">${material.link}</a>
		</p>
		<c:set value="${material.file}" var="file"></c:set>
		<c:set value="${role}" var="role"></c:set>
		<c:choose>
			<c:when test="${file==null}">
				<c:choose>
					<c:when test="${role=='TEACHER'}">
						<a href="/spring-mvc/uploadm/${material.materialID}"><i class="fas fa-plus-circle"></i>Add new
							file</a>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<p>
					File:  <a href="/spring-mvc/material/${materialID}/download"><i class="far fa-file"></i>${material.file}</a>
				</p>
			</c:otherwise>
		</c:choose>
		<p align="center" style="color: green">${msg}</p>

	</div>

</div>