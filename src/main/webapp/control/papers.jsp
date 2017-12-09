<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<jsp:include page="kind.jsp"></jsp:include>
		<div id="page-wrapper">
			<center>
				<a href="control/addPaper.jsp">
					<button type="button" class="btn btn-outline btn-success">添加</button>
				</a>
			</center>
			<div class="dataTable_wrapper">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>论文标题</th>
							<th>作者</th>
							<th>发布时间</th>
							<th>修改</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="paper">
							<tr class="gradeA">
								<td>${paper.title}<input type="hidden" name="id"
									value="${paper.id}">
								</td>
								<td>${paper.author}</td>
								<td>${paper.date}</td>
								<td><a href="control/article/getArticle.do?id=${paper.id}">
										<button type="button" class="btn btn-outline btn-warning">修改</button>
								</a></td>
								
								<c:choose>
								<c:when test="${ fn:length(list) le 4}">
									<td><button type="button" class="btn btn-outline btn-danger notdel">删除</button></td>
								</c:when>
								<c:otherwise>
									<td><button type="button" class="btn btn-outline btn-danger del">删除</button></td>
								</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="control/js/papers.js"></script>
</body>
</html>
