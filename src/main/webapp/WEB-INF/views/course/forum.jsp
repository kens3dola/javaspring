<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<a href="/spring-mvc/${role}/course/${forum.courseID}">Back to
	course</a>
<div align="center">
	<h1>${forum.forumID}${forum.title}</h1>
	<p>${forum.content}</p>
	<br>

</div>

<div class="body">
	<c:forEach var="cmt" items="${comments}" varStatus="status">
		<c:choose>
			<c:when test="${cmt == null}">
				<p>No comment</p>
			</c:when>
			<c:otherwise>
				<div class="xx">
					<p class="itemfr">#${status.index}</p>
					<p class="itemfr2">${cmt.content}</p>
				</div>
				<span>${cmt.userName}</span>
				<span>${cmt.date}</span>
				<hr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>

<form:form class="form"
	action="/spring-mvc/forum/${forum.forumID}/comment" method="post"
	modelAttribute="comment">
	<div class="formcol">
		<form:label path="content">Comment: </form:label>
		<form:input path="content" />
	</div>
	<div class="hidden">
		<form:input path="userName" width="0" />
	</div>
	<input class="submit" type="submit" value="comment">
</form:form>