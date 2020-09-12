<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="vi">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/template/guess/vendor/bootstrap/css/bootstrap.min.css'/> "
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value='/template/guess/css/scrolling-nav.css'/> "
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="guess">Home page</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">News</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">Teachers</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<header class="header">
	</header>
	<dec:body />

	<!--login form-->
	<section id="contact">
		<h1 class="announce">Login</h1>
		<br>
		<form:form id="loginForm" modelAttribute="account" action="login"
			method="post">
			<form:label path="userName">User name</form:label>
			<form:input path="userName" name="userName" id="userName" />
			<form:label path="passWord">Password</form:label>
			<form:password path="passWord" name="passWord" id="passWord" />
			<form:button id="login" name="login">Login</form:button>
		</form:form>
	</section>

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; SAD-DBS
				2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script
		src="<c:url value='/template/guess/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/guess/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- Plug in JavaScript -->
	<script
		src="<c:url value='/template/guess/vendor/jquery-easing/jquery.easing.min.js'/>"></script>


	<!-- Custom JavaScript for this theme -->
	<script src="<c:url value='/template/guess/js/scrolling-nav.js'/>"></script>

</body>

</html>
