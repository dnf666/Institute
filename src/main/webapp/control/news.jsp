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
		<jsp:include page="kind.jsp"></jsp:include>
		<div id="page-wrapper">
			<center>
				<a href="control/news/enterNews.do"><button type="button"
						class="btn btn-outline btn-success ">添加</button></a>
			</center>
			<div class="dataTable_wrapper">

				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>新闻标题</th>
							<th>发布人</th>
							<th>发布时间</th>
							<th>图片</th>
							<th>修改</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="News">
							<tr class="gradeA">
								<td>${News.title}<input type="hidden" name="id"
									value="${News.id}"> <input type="hidden"
									name="pictureId" value="${News.picture.id}">
								</td>
								<td>${News.releaser}</td>
								<td>${News.date}</td>
								<%-- <td><a
									href="control/picture/getPicture.do?id=${News.picture.id}">
										<button type="button" class="btn btn-outline btn-warning">修改图片</button>
								</a></td> --%>
								<td><input type="hidden" name="updatePicture"
									value="<%=basePath%>control/picture/getPicture.do?id=${News.picture.id}">
									<button type="button" class="btn btn-outline btn-warning updatePicture">
										<img style="width:30px;height:30px"
											src="upload/${News.picture.link}">
									</button></td>
								<td><a href="control/news/getSingleNews.do?id=${News.id}">
										<button type="button" class="btn btn-outline btn-warning">修改</button>
								</a></td>
								<td><button type="button"
										class="btn btn-outline btn-danger del">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
		<!-- /#page-wrapper -->
	</div>
	
	<script src="control/js/news.js"></script>
	<script src="layer/layer.js"></script>
	<script src="control/js/updatePicture.js"></script>
</body>
</html>
