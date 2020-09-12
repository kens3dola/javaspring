<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administration</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='/template/admin/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<c:url value='/template/admin/css/small-business.css'/>" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://kit-free.fontawesome.com/releases/latest/css/free.min.css" media="all">
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/admin/header.jsp" %>

	<dec:body/>
	
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>