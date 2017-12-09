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
							<th>方向</th>
							<th>公司</th>
							<th>年级</th>
							<th>简介</th>
							<th>图片</th>
							<th>功能</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="Grad">
							<tr class="gradeA">
								<td><input name="name" size="7" value="${Grad.name}"
									class="form-control" size="5"> <input name="id"
									type="hidden" value="${Grad.id}" class="form-control">
									<input name="pictureId" type="hidden"
									value="${Grad.picture.id}" class="form-control"></td>
								<td><input name="zhiwu" value="${Grad.zhiwu}"
									class="form-control"></td>
								<td><input name="whereabout" value="${Grad.whereabout}"
									class="form-control"></td>
								<td><input name="grade" size="7" value="${Grad.grade}"
									class="form-control"></td>
								<td><textarea name="jianjie" class="form-control" rows="2">${Grad.jianjie}</textarea></td>
								<td><input type="hidden" name="updatePicture"
									value="<%=basePath%>control/picture/getPicture.do?id=${Grad.picture.id}"/>
									<button type="button"
										class="btn btn-outline btn-warning updatePicture">
										<img style="width:30px;height:30px"
											src="upload/${Grad.picture.link}"/>
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
								<th>方向</th>
								<th>公司</th>
								<th>简介</th>
								<th>年级</th>
								<th>添加</th>
							</tr>
						</thead>
						<tbody>
							<tr class="gradeA">
								<td>图片：<input type="file" name="file"></td>
								<td><input name="name" class="form-control"></td>
								<td><input name="zhiwu" class="form-control"></td>
								<td><input name="whereabout" class="form-control"></td>
								<td><textarea name="jianjie" class="form-control" rows="2"></textarea></td>
								<td><input name="grade" class="form-control"></td>
								<td><button class="btn btn-outline btn-success add">添加</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>

	</div>

	<script src="control/js/grad.js"></script>
	<script src="layer/layer.js"></script>
	<script src="control/js/updatePicture.js"></script>
</body>
</html>
