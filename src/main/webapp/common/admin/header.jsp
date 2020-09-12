<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/spring-mvc/admin"><i class="fal fa-home-lg-alt"></i> Home page</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="/spring-mvc/admin/users">Active accounts</a></li>
				<li class="nav-item active"><a class="nav-link" href="/spring-mvc/admin/course">Courses</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="/spring-mvc/admin/register">Create account</a></li>
				<li class="nav-item active"><a class="nav-link" href="/spring-mvc/logout">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>