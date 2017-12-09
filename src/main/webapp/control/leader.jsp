<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
							<th>姓名</th>
							<th>专业</th>
							<th>职称</th>
							<th>简介</th>
							<th>图片</th>
							<th>功能</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="Leader">
							<tr class="gradeA">
								<td><input name="name" value="${Leader.name}"
									class="form-control"> <input name="id"
									value="${Leader.id}" class="form-control" type="hidden">
									<input name="pictureId" value="${Leader.picture.id}"
									class="form-control" type="hidden"></td>
								<td><input name="xibie" value="${Leader.xibie}"
									class="form-control"></td>
								<td><input name="zhicheng" value="${Leader.zhicheng}"
									class="form-control"></td>
								<td><textarea name="jianjie" class="form-control" rows="2">${Leader.jianjie}</textarea></td>
								<%-- <td><a
									href="control/picture/getPicture.do?id=${Leader.picture.id}">
										<button type="button" class="btn btn-outline btn-warning">修改图片</button>
								</a></td> --%>
								<td><input type="hidden" name="updatePicture"
									value="<%=basePath%>control/picture/getPicture.do?id=${Leader.picture.id}">
									<button type="button" class="btn btn-outline btn-warning updatePicture">
										<img style="width:30px;height:30px"
											src="upload/${Leader.picture.link}">
									</button></td>
								
								<td>
									<button type="button"
										class="btn btn-outline btn-warning modify">保存</button>
									<button type="button" class="btn btn-outline btn-danger del">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="dataTable_wrapper">
				<form id="myform" method="post" enctype="multipart/form-data">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>图片</th>
								<th>姓名</th>
								<th>专业</th>
								<th>职称</th>
								<th>简介</th>
								<th>添加</th>
							</tr>
						</thead>
						<tbody>
							<tr class="gradeA">
								<td><input type="file" name="file"></td>
								<td><input name="name" class="form-control"></td>
								<td><input name="xibie" class="form-control"></td>
								<td><input name="zhicheng" class="form-control"></td>
								<td><textarea name="jianjie" class="form-control" rows="2"></textarea></td>
								<td><button class="btn btn-outline btn-success add">添加</button></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>

		</div>
		<!-- /#page-wrapper -->

	</div>
	
	<script src="control/js/leader.js"></script>
	<script src="layer/layer.js"></script>
	<script src="control/js/updatePicture.js"></script>
</body>
</html>
