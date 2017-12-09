<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%
	String path = request.getContextPath() + "/";
%>
<base href="<%=path%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>研究所后台管理系统</title>

<!-- Bootstrap Core CSS -->
<link href="control/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="control/css/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="control/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="control/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form id="myform" method="post" onsubmit="return false">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Username"
										name="userName" type="userName" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" type="hidden" name="indexurl"
										value="control/picture/loadIndex.do">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password">
								</div>

								<!-- Change this to a button or input when using this as a form -->
								<button class="btn btn-lg btn-success btn-block login">login</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="control/js/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="control/js/bootstrap.min.js"></script>
	<script src="control/js/jquery.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="control/js/metisMenu.min.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="control/js/sb-admin-2.js"></script>
	<script src="control/js/login.js"></script>

</body>

</html>
