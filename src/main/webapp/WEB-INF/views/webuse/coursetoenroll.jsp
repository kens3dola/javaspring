<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<h1>Course: ${course.courseID} ${course.courseName}</h1>

	<h2>Teacher</h2>
	<p>${teacher.teacherID}</p>
	<p>${teacher.teacherName}</p>

	<h2>Max: ${course.maxStudent}</h2>
	<h2>Start in: ${course.start} End in: ${course.end}</h2>

	<a href="${course.courseID}/${isenroll}">${isenroll}</a>
</div>