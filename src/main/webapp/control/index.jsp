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
		<!-- Navigation -->
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="dataTable_wrapper">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>预览</th>
							<th>类别</th>
							<th>功能</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${map.listLogos}" var="Picture">
							<tr class="gradeA">
								<td style="width:100px;height:100px"><img
									src="upload/${Picture.link}" style="width:100px;height:100px" /></td>
								<td>${Picture.type}</td>
								<%-- <td><a
									href="control/picture/getPicture.do?id=${Picture.id}">
										<button class="btn btn-outline btn-warning updatePicture">重传</button>
								</a></td> --%>
								<td><input type="hidden" name="updatePicture"
									value="<%=basePath%>control/picture/getPicture.do?id=${Picture.id}">
									<button type="button"
										class="btn btn-outline btn-warning updatePicture">重传
									</button></td>
								<td>
							</tr>
						</c:forEach>
						<c:forEach items="${map.listPapers}" var="Picture">
							<tr class="gradeA">
								<td style="width:100px;height:100px"><img
									src="upload/${Picture.link}" style="width:100px;height:100px" /></td>
								<td>${Picture.type}</td>
								<%-- <td><a
									href="control/picture/getPicture.do?id=${Picture.id}">
										<button class="btn btn-outline btn-warning ">重传</button>
								</a></td> --%>
								<td><input type="hidden" name="updatePicture"
									value="<%=basePath%>control/picture/getPicture.do?id=${Picture.id}">
									<button type="button"
										class="btn btn-outline btn-warning updatePicture">重传
									</button></td>
								<td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="layer/layer.js"></script>
	<script src="control/js/updatePicture.js"></script>
</body>
</html>
