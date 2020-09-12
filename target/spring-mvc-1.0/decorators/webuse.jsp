<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faculty of Information Technology</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value='/template/webuse/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link
	href="<c:url value='/template/webuse/vendor/datatables/dataTables.bootstrap4.css'/>"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="<c:url value='/template/webuse/css/sb-admin.css'/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value='/template/webuse/css/scrolling-nav.css'/>"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://kit-free.fontawesome.com/releases/latest/css/free.min.css"
	media="all">

</head>
<body id="page-top">

	<%@ include file="/common/webuse/header.jsp"%>
	<div id="content-wrapper">
		<dec:body />
		<div class="container-fluid"></div>
		<!-- /.content-wrapper -->

	</div>
	
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Are you sure want to log out?</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="/spring-mvc/logout">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value='/template/webuse/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/webuse/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/webuse/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Page level plugin JavaScript-->
	<script
		src="<c:url value='/template/webuse/vendor/chart.js/Chart.min.js'/>"></script>
	<script
		src="<c:url value='/template/webuse/vendor/datatables/jquery.dataTables.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/webuse/js/sb-admin.min.js'/>"></script>

	<!-- Demo scripts for this page-->
	<script
		src="<c:url value='/template/webuse/js/demo/datatables-demo.js'/>"></script>
	<script
		src="<c:url value='/template/webuse/js/demo/chart-area-demo.js'/>"></script>
</body>
</html>