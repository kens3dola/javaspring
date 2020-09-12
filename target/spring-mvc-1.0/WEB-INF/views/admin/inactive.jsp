<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 class="header">Inactive accounts</h1>

<table class="table" border="1">
	<tr align="center">
		<th>User name</th>
		<th>Password</th>
		<th>Role</th>
		<th></th>
	</tr>
	<c:forEach var="inactive" items="${inactive}" varStatus="status">
		<tr align="center">
			<td width="200">${inactive.userName}</td>
			<td width="200">${inactive.passWord}</td>
			<td width="200">${inactive.userRole}</td>
			<td> <a
				href="/spring-mvc/admin/inactive/delete/${inactive.userName}"><i class="fas fa-user-slash"></i> Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>