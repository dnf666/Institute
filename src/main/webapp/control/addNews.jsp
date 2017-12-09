<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<jsp:include page="kind.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="dataTable_wrapper">
				<form id="myform" method="post" enctype="multipart/form-data">
					<table class="table table-striped table-bordered table-hover">
						<tbody>
							<tr class="gradeA">
								<td>新闻标题：</td>
								<td><input name="title"></td>
							</tr>
							<tr class="gradeA">
								<td>新闻发布者：</td>
								<td><select name="releaser">
										<c:forEach items="${list}" var="user">
											<option>${user.userName}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr class="gradeA">
								<td>新闻摘要：</td>
								<td><textarea name="summary" class="form-control" rows="5"></textarea></td>
							</tr>
							<tr class="gradeA">
								<td>新闻内容：</td>
								<td><textarea name="content" class="form-control" rows="10"></textarea></td>
							</tr>
							<tr class="gradeA">
								<td>新闻图片：</td>
								<td><input type="file" name="file"></td>
							</tr>
							<tr class="gradeA">
								<td>保存：</td>
								<td>
									<button type="button" class="btn btn-outline btn-warning add">添加</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	
	<script src="control/js/news.js"></script>
</body>
</html>
