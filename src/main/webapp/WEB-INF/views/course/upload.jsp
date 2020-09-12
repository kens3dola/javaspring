<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h2>Add New File</h2>
<form action="/spring-mvc/upload" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td width="35%"><strong>File to upload( must in .zip format):</strong></td>
			<td width="65%"><input type="file" name="file" /></td>
		</tr>
		<tr>
			<td><strong>Title:</strong></td>
			<td><input type="text" name="title" width="60" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" name="submit" value="Add" /></td>
		</tr>
	</table>
</form>