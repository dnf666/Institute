<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>研究所后台管理页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%
String path = request.getContextPath()+"/";
%>
<base href="<%=path%>">
<link href="control/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="control/css/metisMenu.min.css" rel="stylesheet">
<!-- DataTables CSS -->
<link href="control/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="control/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="control/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<script src="control/js/jquery.js"></script>
<script src="control/js/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="control/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="control/js/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="control/js/jquery.dataTables.min.js"></script>
<script src="control/js/dataTables.bootstrap.min.js"></script>



<!-- Page-Level Demo Scripts - Tables - Use for reference -->

</head>

<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation"
		style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.html">研究所后台管理系统</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown"><strong>${sessionScope.username}欢迎您
		</strong></li>
		<!-- /.dropdown -->
		<li class="dropdown"><a class="text-center"
			href="control/signOut.do"> <strong>退出登录</strong></a> <i
			class="fa fa-angle-right"></i></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li><a href="control/picture/loadIndex.do"><i
						class="fa fa-dashboard fa-fw"></i>首页</a></li>
				<li><a href="control/news/getNews.do"><i
						class="fa fa-dashboard fa-fw"></i>新闻动态</a></li>
				<li><a href="control/article/getArticles.do"><i
						class="fa fa-dashboard fa-fw"></i>论文专著</a></li>
				<li><a href="javascript:;"><i class="fa fa-dashboard fa-fw"></i>研究所</a>
					<ul class="nav nav-second-level">
						<li><a href="control/leader/getLeaders.do">学术带头人</a></li>
						<li><a href="control/member/getMembers.do">成员介绍</a></li>
						<li><a href="control/grad/getGrads.do">已毕业成员</a></li>
						<li><a href="control/grad/getPostGrads.do">研究生</a></li>
					</ul></li>
				<li><a href="javascript:;"><i class="fa fa-dashboard fa-fw"></i>研究成果</a>
					<ul class="nav nav-second-level">
						<li><a href="control/doingProject/getDoingProjects.do">在研项目</a>
						</li>
						<li><a href="control/doneProject/getDoneProjects.do">已完成项目</a>
						</li>
					</ul></li>
				<li><a href="control/department/getDepartments.do"><i
						class="fa fa-dashboard fa-fw"></i>相关单位</a></li>
				<%--todo--%>
				<li><a href="control/extraMessage/getMessage.do"><i
						class="fa fa-dashboard fa-fw"></i>额外信息</a></li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side --> </nav>
	<!-- Custom Theme JavaScript -->
	<script src="control/js/sb-admin-2.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>
</html>
