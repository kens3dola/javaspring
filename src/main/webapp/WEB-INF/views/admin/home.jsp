<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Page Content -->
<div class="container">

	<!-- Heading Row -->
	<div class="row align-items-center my-5">
		<div class="col-lg-7">
			<img class="img-fluid rounded mb-4 mb-lg-0"
				src="http://fit.hanu.vn/pluginfile.php/1/theme_essential/slide1image/1574932483/about-banner.jpg" alt="">
		</div>
		<!-- /.col-lg-8 -->
		<div class="col-lg-5 card-body">
			<h1 class="font-weight-light count">News</h1>
			<p>Total: ${notifications}</p>
		</div>
		<!-- /.col-md-4 -->
	</div>

	<!-- Content Row -->
	<div class="row">
		<div class="col-md-4 mb-5">
			<div class="card h-100">
				<div class="card-body">
					<h2 class="card-title count">Courses</h2>
					<p class="card-text">Total: ${courses } </p>
				</div>
			</div>
		</div>
		<!-- /.col-md-4 -->
		<div class="col-md-4 mb-5">
			<div class="card h-100">
				<div class="card-body count">
					<h2 class="card-title">Teachers</h2>
					<p class="card-text">Total: ${teachers}</p>
				</div>
			</div>
		</div>
		<!-- /.col-md-4 -->
		<div class="col-md-4 mb-5">
			<div class="card h-100">
				<div class="card-body count">
					<h2 class="card-title">Students</h2>
					<p class="card-text">Total: ${students}</p>
				</div>
			</div>
		</div>
		<!-- /.col-md-4 -->

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->