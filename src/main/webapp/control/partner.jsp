<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="dataTable_wrapper">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>相关单位名称</th>
							<th>相关单位链接</th>
							<th>图片</th>
							<th>修改</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="Department">
							<tr class="gradeA">
								<td><input name="name" value="${Department.name}"
									class="form-control"></td>
								<td><input name="url" value="${Department.url}"
									class="form-control"> <input name="id"
									value="${Department.id}" type="hidden"> <input
									name="pictureId" value="${Department.picture.id}" type="hidden">
								</td>
								
								<td>
								<input type="hidden" name="updatePicture" value="<%=basePath%>control/picture/getPicture.do?id=${Department.picture.id}">
								<button type="button"
										class="btn btn-outline btn-warning updatePicture">
										<img style="width:30px;height:30px" src="upload/${Department.picture.link}">
									</button></td>
								<td><button type="button"
										class="btn btn-outline btn-warning modify">保存</button></td>
								<td><button type="button"
										class="btn btn-outline btn-danger del">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="dataTable_wrapper">
				<form id="mform" method="post" enctype="multipart/form-data">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>相关单位名称</th>
								<th>相关单位链接</th>
								<th>图片</th>
								<th>添加</th>
							</tr>
						</thead>
						<tbody>
							<tr class="gradeA">
								<td><input name="name" class="form-control"></td>
								<td><input name="url" class="form-control"></td>
								<td><input name="file" type="file"></td>
								<td><button type="button"
										class="btn btn-outline btn-success add">添加</button></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	
	<script src="control/js/partner.js"></script>
	<script src="layer/layer.js"></script>
	<script src="control/js/updatePicture.js"></script>
</body>
</html>
