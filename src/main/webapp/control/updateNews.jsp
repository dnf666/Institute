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
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr class="gradeA">
							<td>新闻标题：${map.News.releaser}</td>
							<td><input name="title" value="${map.News.title}"> <input
								name="id" type="hidden" value="${map.News.id}"></td>

						</tr>
						
						<tr class="gradeA">
							<td>新闻发布者：</td>
							<td><select name="releaser">
									<c:forEach items="${map.userList}" var="user">
										<c:choose>
											<c:when test="${map.News.releaser eq user.userName}">
												<option selected="true">${user.userName}</option>
												<%//System.out.println("lallapppppppp"); %>
												
											</c:when>
											<c:otherwise>
												<option>${user.userName}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>

							</select></td>
						</tr>
						<tr class="gradeA">
							<td>新闻摘要：</td>
							<td><textarea name="summary" class="form-control" rows="5">${map.News.summary}</textarea></td>
						</tr>
						<tr class="gradeA">
							<td>新闻内容：</td>
							<td><textarea name="content" class="form-control" rows="10">${map.News.content}</textarea></td>
						</tr>
						<tr class="gradeA">
							<td>保存：</td>
							<td>
								<button type="button" class="btn btn-outline btn-warning modify">保存</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

<script src="control/js/news.js"></script>
</html>
