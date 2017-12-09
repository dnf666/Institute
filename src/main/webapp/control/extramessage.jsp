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
					<th>姓名</th>
					<th>电话</th>
					<th>邮箱</th>
					<th>修改</th>

				</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="ExtraMessage">
					<tr class="gradeA">
						<td><input name="name" value="${ExtraMessage.name}"
								   class="form-control"></td>
						<td><input name="phone" value="${ExtraMessage.phone}"
								   class="form-control">
						</td><td><input name="email" value="${ExtraMessage.email}" class="form-control">
							<%--<input--%>
								<%--name="pictureId" value="${Department.picture.id}" type="hidden">--%>
						</td>

						<td><button type="button"
									class="btn btn-outline btn-warning modify">保存</button></td>

					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->

</div>
//todo
<script src="control/js/extraMessage.js"></script>
<script src="layer/layer.js"></script>
<script src="control/js/updatePicture.js"></script>
</body>
</html>
